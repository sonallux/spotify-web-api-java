package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Playlist Cover Image request
 *
 * <h3>Response</h3>
 * <p>A set of images</p>
 */
public class GetPlaylistCoverRequest {
    private static final TypeReference<java.util.List<Image>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Playlist Cover Image request</h3>
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     */
    public GetPlaylistCoverRequest(ApiClient apiClient, String playlistId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/playlists/{playlist_id}/images")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<java.util.List<Image>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
