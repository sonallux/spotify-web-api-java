package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Reorder Playlist Items request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A snapshot ID for the playlist</p>
 */
public class ReorderPlaylistsTracksRequest {
    private static final TypeReference<PlaylistSnapshotId> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Reorder Playlist Items request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     * @param rangeStart <p>The position of the first item to be reordered.</p>
     * @param insertBefore <p>The position where the items should be inserted.<br>To reorder the items to the end of the playlist, simply set <em>insert_before</em> to the position after the last item.<br>Examples:<br>To reorder the first item to the last position in a playlist with 10 items, set <em>range_start</em> to 0, and <em>insert_before</em> to 10.<br>To reorder the last item in a playlist with 10 items to the start of the playlist, set <em>range_start</em> to 9, and <em>insert_before</em> to 0.</p>
     */
    public ReorderPlaylistsTracksRequest(ApiClient apiClient, String playlistId, int rangeStart, int insertBefore) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}/tracks")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addBodyParameter("range_start", rangeStart)
            .addBodyParameter("insert_before", insertBefore)
        ;
    }

    /**
     * @param rangeLength <p>The amount of items to be reordered. Defaults to 1 if not set.<br>The range of items to be reordered begins from the <em>range_start</em> position, and includes the <em>range_length</em> subsequent items.<br>Example:<br>To move the items at index 9-10 to the start of the playlist, <em>range_start</em> is set to 9, and <em>range_length</em> is set to 2.</p>
     * @return this request
     */
    public ReorderPlaylistsTracksRequest rangeLength(int rangeLength) {
        this.request.addBodyParameter("range_length", rangeLength);
        return this;
    }

    /**
     * @param snapshotId <p>The playlist's snapshot ID against which you want to make the changes.</p>
     * @return this request
     */
    public ReorderPlaylistsTracksRequest snapshotId(String snapshotId) {
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
