package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Remove Playlist Items request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A snapshot ID for the playlist</p>
 */
public class RemoveTracksPlaylistRequest {
    private static final TypeReference<PlaylistSnapshotId> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Remove Playlist Items request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     * @param tracks <p>An array of objects containing <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify URIs</a> of the tracks or episodes to remove. For example: <code>{ &quot;tracks&quot;: [{ &quot;uri&quot;: &quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot; },{ &quot;uri&quot;: &quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot; }] }</code>. A maximum of 100 objects can be sent at once.</p>
     */
    public RemoveTracksPlaylistRequest(ApiClient apiClient, String playlistId, java.util.List<java.util.Map<String, Object>> tracks) {
        this.apiClient = apiClient;
        this.request = new Request("DELETE", "/playlists/{playlist_id}/tracks")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addBodyParameter("tracks", tracks)
        ;
    }

    /**
     * @param snapshotId <p>The playlist's snapshot ID against which you want to make the changes. The API will validate that the specified items exist and in the specified positions and make the changes, even if more recent changes have been made to the playlist.</p>
     * @return this request
     */
    public RemoveTracksPlaylistRequest snapshotId(String snapshotId) {
        this.request.addBodyParameter("snapshot_id", snapshotId);
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<PlaylistSnapshotId> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
