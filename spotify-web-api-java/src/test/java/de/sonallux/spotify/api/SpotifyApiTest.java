package de.sonallux.spotify.api;

import de.sonallux.spotify.api.authorization.ApiAuthorizationProvider;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpotifyApiTest {
    @Mock
    ApiAuthorizationProvider apiAuthorizationProvider;

    private MockWebServer webServer;
    private SpotifyWebApi api;

    @BeforeEach
    void setup() throws IOException {
        webServer = new MockWebServer();
        webServer.start();
        var baseUrl = webServer.url("/");
        api = SpotifyWebApi.builder().baseUrl(baseUrl).authorization(apiAuthorizationProvider).build();
    }

    @AfterEach
    void teardown() throws IOException{
        webServer.close();
    }

    @Test
    void addNoAuthorizationHeaderToRequest() throws Exception {
        when(apiAuthorizationProvider.getAuthorizationHeaderValue()).thenReturn(null);
        webServer.enqueue(mockResponseArtist);

        var artist = api.getArtistsApi().getArtist("foo").build().execute();
        assertNotNull(artist);
        assertEquals("0OdUWJ0sBjDrqHygGUXeCF", artist.getId());
        assertEquals("https://open.spotify.com/artist/0OdUWJ0sBjDrqHygGUXeCF", artist.getExternalUrls().getSpotify());

        assertEquals(1, webServer.getRequestCount());
        var request = webServer.takeRequest();
        assertEquals("GET /artists/foo HTTP/1.1", request.getRequestLine());
        assertNull(request.getHeaders().get("Authorization"));
    }

    @Test
    void addAuthorizationHeaderToRequest() throws Exception {
        when(apiAuthorizationProvider.getAuthorizationHeaderValue()).thenReturn("Bearer some-access-token");
        webServer.enqueue(mockResponseArtist);

        var artist = api.getArtistsApi().getArtist("foo").build().execute();
        assertNotNull(artist);
        assertEquals("0OdUWJ0sBjDrqHygGUXeCF", artist.getId());
        assertEquals("https://open.spotify.com/artist/0OdUWJ0sBjDrqHygGUXeCF", artist.getExternalUrls().getSpotify());

        assertEquals(1, webServer.getRequestCount());
        var request = webServer.takeRequest();
        assertEquals("GET /artists/foo HTTP/1.1", request.getRequestLine());
        assertEquals("Bearer some-access-token", request.getHeaders().get("Authorization"));
    }

    @Test
    void handlesUnauthorizedResponseWithRetry() throws Exception {
        when(apiAuthorizationProvider.getAuthorizationHeaderValue()).thenReturn(null);
        when(apiAuthorizationProvider.refreshAccessToken()).thenReturn(true);
        webServer.enqueue(mockResponseUnauthorizedInvalidToken);
        webServer.enqueue(mockResponseArtist);

        var artist = api.getArtistsApi().getArtist("foo").build().execute();
        assertNotNull(artist);
        assertEquals("0OdUWJ0sBjDrqHygGUXeCF", artist.getId());

        verify(apiAuthorizationProvider, times(1)).refreshAccessToken();

        assertEquals(2, webServer.getRequestCount());
        var request1 = webServer.takeRequest();
        assertEquals("GET /artists/foo HTTP/1.1", request1.getRequestLine());
        var request2 = webServer.takeRequest();
        assertEquals("GET /artists/foo HTTP/1.1", request2.getRequestLine());
    }

    @Test
    void handlesUnauthorizedResponseWithFailure() throws Exception {
        when(apiAuthorizationProvider.getAuthorizationHeaderValue()).thenReturn(null);
        when(apiAuthorizationProvider.refreshAccessToken()).thenReturn(false);
        webServer.enqueue(mockResponseUnauthorizedInvalidToken);

        assertThrows(SpotifyApiException.class, () -> api.getArtistsApi().getArtist("foo").build().execute());

        verify(apiAuthorizationProvider, times(1)).refreshAccessToken();

        assertEquals(1, webServer.getRequestCount());
        var request1 = webServer.takeRequest();
        assertEquals("GET /artists/foo HTTP/1.1", request1.getRequestLine());
    }

    private final MockResponse mockResponseUnauthorizedInvalidToken = new MockResponse.Builder()
        .code(401)
        .body("{\"error\": {\"status\": 401,\"message\": \"Invalid access token\"}}")
        .build();

    private final MockResponse mockResponseArtist = new MockResponse.Builder()
        .code(200)
        .body("{\n" +
            "  \"external_urls\" : {\n" +
            "    \"spotify\" : \"https://open.spotify.com/artist/0OdUWJ0sBjDrqHygGUXeCF\"\n" +
            "  },\n" +
            "  \"followers\" : {\n" +
            "    \"href\" : null,\n" +
            "    \"total\" : 306565\n" +
            "  },\n" +
            "  \"genres\" : [ \"indie folk\", \"indie pop\" ],\n" +
            "  \"href\" : \"https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF\",\n" +
            "  \"id\" : \"0OdUWJ0sBjDrqHygGUXeCF\",\n" +
            "  \"images\" : [ {\n" +
            "    \"height\" : 816,\n" +
            "    \"url\" : \"https://i.scdn.co/image/eb266625dab075341e8c4378a177a27370f91903\",\n" +
            "    \"width\" : 1000\n" +
            "  }, {\n" +
            "    \"height\" : 52,\n" +
            "    \"url\" : \"https://i.scdn.co/image/4f25297750dfa4051195c36809a9049f6b841a23\",\n" +
            "    \"width\" : 64\n" +
            "  } ],\n" +
            "  \"name\" : \"Band of Horses\",\n" +
            "  \"popularity\" : 59,\n" +
            "  \"type\" : \"artist\",\n" +
            "  \"uri\" : \"spotify:artist:0OdUWJ0sBjDrqHygGUXeCF\"\n" +
            "}")
        .build();
}
