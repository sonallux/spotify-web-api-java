package de.sonallux.spotify.api;

import de.sonallux.spotify.api.models.Episode;
import de.sonallux.spotify.api.models.Track;
import mockwebserver3.MockWebServer;
import mockwebserver3.MockResponse;
import okio.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {
    private MockWebServer webServer;
    private SpotifyWebApi api;

    @BeforeEach
    void setup() throws IOException {
        webServer = new MockWebServer();
        webServer.start();
        var baseUrl = webServer.url("/");
        api = SpotifyWebApi.builder().baseUrl(baseUrl).build();
    }

    @AfterEach
    void teardown() {
        webServer.close();
    }

    @Test
    void testResponseSnakeCaseToCamelCase() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlist.json"));

        var playlist = api.getPlaylistsApi().getPlaylist("foo").build().execute();
        assertEquals("37i9dQZF1DX4TiN7pMwV0Z", playlist.getId());
        assertEquals("MTYxNTI3MzcxMSwwMDAwMDAwMDcxOTM3NDM1NDIxMmIzODI4NGQzMDI0OGRiZGQ4M2Q4", playlist.getSnapshotId());
        assertFalse(playlist.isPublic());
        assertEquals("Spotify", playlist.getOwner().getDisplayName());
        var firstTrack = playlist.getTracks().getItems().getFirst();
        assertNotNull(firstTrack);
        assertEquals(Instant.parse("2021-03-07T23:01:00Z"), firstTrack.getAddedAt());
        assertInstanceOf(Track.class, firstTrack.getTrack());
        assertEquals(6, ((Track) firstTrack.getTrack()).getTrackNumber());
    }

    @Test
    void testRequestWithReservedKeyWord() throws Exception {
        webServer.enqueue(mockResponse(200).build());

        var response = api.getPlaylistsApi().changePlaylistDetails("foo")
            .name("Test")
            .collaborative(false)
            .description("Test description")
            ._public(true)
            .build().executeCall();
        assertTrue(response.isSuccessful());

        var request = webServer.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeaders().get("Content-Type"));
        var actualBody = request.getBody().utf8();
        assertEquals("{\"name\":\"Test\",\"collaborative\":false,\"description\":\"Test description\",\"public\":true}", actualBody);
    }

    @Test
    void testRequestWithEmptyBodyObject() throws Exception {
        webServer.enqueue(mockResponse(200).build());

        var response = api.getPlaylistsApi().changePlaylistDetails("foo").build().executeCall();
        assertTrue(response.isSuccessful());

        var request = webServer.takeRequest();
        var actualBody = request.getBody().utf8();
        assertEquals("", actualBody);
    }

    @Test
    void testRequestWithSnakeCaseToCamelCase() throws Exception {
        webServer.enqueue(mockResponse(200).body("{\"snapshot_id\":\"12ab34cd\"}").build());

        var newSnapshotId = api.getPlaylistsApi().removeTracksPlaylist("foo", List.of())
            .snapshotId("ab12cd34")
            .build().execute();
        assertEquals("12ab34cd", newSnapshotId.getSnapshotId());

        var request = webServer.takeRequest();
        assertEquals("application/json; charset=UTF-8", request.getHeaders().get("Content-Type"));
        var actualBody = request.getBody().utf8();
        assertEquals("{\"tracks\":[],\"snapshot_id\":\"ab12cd34\"}", actualBody);
    }

    @Test
    void testUnionTypeHandlingWithAdditionalTypesParameter() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlists-tracks-union.json"));

        var response = api.getPlaylistsApi().getPlaylistsTracks("foo").build().execute();
        var track = response.getItems().getFirst().getTrack();
        assertNotNull(track);
        assertEquals("track", track.getType());
        assertInstanceOf(Track.class, track);

        var episode = response.getItems().get(1).getTrack();
        assertNotNull(episode);
        assertEquals("episode", episode.getType());
        assertInstanceOf(Episode.class, episode);
        assertNotNull(((Episode) episode).getShow());

        var request = webServer.takeRequest();
        assertEquals("/playlists/foo/tracks", request.getUrl().encodedPath());
        assertEquals("additional_types=track%2Cepisode", request.getUrl().encodedQuery());
    }

    @Test
    void testUnionTypeHandlingWithoutAdditionalTypesParameter() throws Exception {
        webServer.enqueue(loadMockResponse("get-playlists-tracks.json"));

        var response = api.getPlaylistsApi().getPlaylistsTracks("foo")
            .additionalTypes("track")
            .build().execute();
        var track = response.getItems().getFirst().getTrack();
        assertNotNull(track);
        assertEquals("track", track.getType());
        assertInstanceOf(Track.class, track);

        var episode = response.getItems().get(1).getTrack();
        assertNotNull(episode);
        assertEquals("episode", episode.getType());
        assertInstanceOf(Episode.class, episode);
        assertNull(((Episode) episode).getShow());//show is not set, because episode is returned with track format

        var request = webServer.takeRequest();
        assertEquals("/playlists/foo/tracks", request.getUrl().encodedPath());
        assertEquals("additional_types=track", request.getUrl().encodedQuery());
    }

    @Test
    void testEmptyResponseBodyWithNonVoidType() throws Exception {
        webServer.enqueue(mockResponse(204).build());

        var response = api.getPlayerApi().getRecentlyPlayed().build().executeCall();
        assertTrue(response.isSuccessful());
        assertNull(response.body());
    }

    private MockResponse loadMockResponse(String fileName) throws Exception {
        var stream = ConversionTest.class.getResourceAsStream("/responses/" + fileName);
        var buffer = new Buffer().readFrom(stream);
        return mockResponse(200)
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .body(buffer)
            .build();
    }

    private MockResponse.Builder mockResponse(int status) {
        return new MockResponse.Builder().code(status);
    }
}
