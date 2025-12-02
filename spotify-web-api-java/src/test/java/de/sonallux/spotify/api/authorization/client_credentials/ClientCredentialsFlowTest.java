package de.sonallux.spotify.api.authorization.client_credentials;

import de.sonallux.spotify.api.authorization.SpotifyAuthorizationException;
import de.sonallux.spotify.api.authorization.TokenStore;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import mockwebserver3.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientCredentialsFlowTest {
    private MockWebServer webServer;
    private ClientCredentialsFlow clientCredentialsFlow;

    @Mock
    TokenStore tokenStore;

    @BeforeEach
    void setup() throws IOException {
        webServer = new MockWebServer();
        webServer.start();
        var baseUrl = webServer.url("/");
        clientCredentialsFlow = new ClientCredentialsFlow("1a2b3c4d5e6f7", "bar456", tokenStore, baseUrl);
    }

    @AfterEach
    void teardown() throws IOException{
        webServer.close();
    }

    @Test
    void authorizeSuccessTest() throws Exception {
        webServer.enqueue(mockResponseAuthTokens);

        clientCredentialsFlow.authorize();

        assertEquals(1, webServer.getRequestCount());
        assertAuthTokensRequest(webServer.takeRequest());

        verify(tokenStore, times(1)).storeTokens(argThat(authTokens -> {
            assertEquals("NgA6ZcYIixn8bU", authTokens.getAccessToken());
            assertEquals("Bearer", authTokens.getTokenType());
            assertEquals(3600, authTokens.getExpiresIn());
            assertNull(authTokens.getScope());
            assertNull(authTokens.getRefreshToken());
            return true;
        }));
    }

    @Test
    void authorizeFailureTest() throws Exception {
        webServer.enqueue(mockResponseBadRequestAuthTokens);

        assertThrows(SpotifyAuthorizationException.class, () -> clientCredentialsFlow.authorize());

        assertEquals(1, webServer.getRequestCount());
        assertAuthTokensRequest(webServer.takeRequest());

        verify(tokenStore, times(0)).storeTokens(any());
    }

    private void assertAuthTokensRequest(RecordedRequest request) {
        assertEquals("POST", request.getMethod());
        assertEquals("/api/token", request.getUrl().encodedPath());
        assertEquals("Basic MWEyYjNjNGQ1ZTZmNzpiYXI0NTY=", request.getHeaders().get("Authorization"));
        assertEquals("application/x-www-form-urlencoded", request.getHeaders().get("Content-Type"));
        assertEquals("grant_type=client_credentials", request.getBody().utf8());
    }

    private final MockResponse mockResponseAuthTokens = new MockResponse.Builder()
        .code(200)
        .body("{\n" +
            "   \"access_token\": \"NgA6ZcYIixn8bU\",\n" +
            "   \"token_type\": \"Bearer\",\n" +
            "   \"expires_in\": 3600\n" +
            "}")
        .build();

    private final MockResponse mockResponseBadRequestAuthTokens = new MockResponse.Builder()
        .code(400)
        .body("{\"error\":\"invalid_client\",\"error_description\":\"Invalid client\"}")
        .build();
}
