package de.sonallux.spotify.api.apis.follow;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Check if Users Follow Playlist request</h2>
 *
 * <h3>Response</h3>
 * <p>Array of booleans</p>
 */
public class CheckIfUserFollowsPlaylistRequest {
    private static final TypeReference<java.util.List<Boolean>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Check if Users Follow Playlist request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param ids <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify User IDs</a> ; the ids of the users that you want to check to see if they follow the playlist. Maximum: 5 ids.</p>
     */
    public CheckIfUserFollowsPlaylistRequest(ApiClient apiClient, String playlistId, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/playlists/{playlist_id}/followers/contains")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<java.util.List<Boolean>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
