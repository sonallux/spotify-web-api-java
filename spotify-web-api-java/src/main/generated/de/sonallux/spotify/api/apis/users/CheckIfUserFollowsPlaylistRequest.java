package de.sonallux.spotify.api.apis.users;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Check if Current User Follows Playlist request</h2>
 *
 * <h3>Response</h3>
 * <p>Array of boolean, containing a single boolean</p>
 */
@NullMarked
public class CheckIfUserFollowsPlaylistRequest {
    private static final TypeReference<java.util.List<Boolean>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Check if Current User Follows Playlist request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     */
    public CheckIfUserFollowsPlaylistRequest(ApiClient apiClient, String playlistId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/playlists/{playlist_id}/followers/contains")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
        ;
    }

    /**
     * @param ids <p><strong>Deprecated</strong> A single item list containing current user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify Username</a>. Maximum: 1 id.</p>
     * @return this request
     */
    public CheckIfUserFollowsPlaylistRequest ids(String ids) {
        this.request.addQueryParameter("ids", String.valueOf(ids));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<java.util.List<Boolean>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
