package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Update Playlist Items request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A snapshot ID for the playlist</p>
 */
@NullMarked
public class ReorderOrReplacePlaylistsItemsRequest {
    private static final TypeReference<PlaylistSnapshotId> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Update Playlist Items request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris 
     */
    public ReorderOrReplacePlaylistsItemsRequest(ApiClient apiClient, String playlistId, java.util.List<String> uris) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}/items")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addBodyParameter("uris", uris)
        ;
    }

    /**
     * @param rangeStart <p>The position of the first item to be reordered.</p>
     * @return this request
     */
    public ReorderOrReplacePlaylistsItemsRequest rangeStart(int rangeStart) {
        this.request.addBodyParameter("range_start", rangeStart);
        return this;
    }

    /**
     * @param insertBefore <p>The position where the items should be inserted.<br/>To reorder the items to the end of the playlist, simply set <em>insert_before</em> to the position after the last item.<br/>Examples:<br/>To reorder the first item to the last position in a playlist with 10 items, set <em>range_start</em> to 0, and <em>insert_before</em> to 10.<br/>To reorder the last item in a playlist with 10 items to the start of the playlist, set <em>range_start</em> to 9, and <em>insert_before</em> to 0.</p>
     * @return this request
     */
    public ReorderOrReplacePlaylistsItemsRequest insertBefore(int insertBefore) {
        this.request.addBodyParameter("insert_before", insertBefore);
        return this;
    }

    /**
     * @param rangeLength <p>The amount of items to be reordered. Defaults to 1 if not set.<br/>The range of items to be reordered begins from the <em>range_start</em> position, and includes the <em>range_length</em> subsequent items.<br/>Example:<br/>To move the items at index 9-10 to the start of the playlist, <em>range_start</em> is set to 9, and <em>range_length</em> is set to 2.</p>
     * @return this request
     */
    public ReorderOrReplacePlaylistsItemsRequest rangeLength(int rangeLength) {
        this.request.addBodyParameter("range_length", rangeLength);
        return this;
    }

    /**
     * @param snapshotId <p>The playlist's snapshot ID against which you want to make the changes.</p>
     * @return this request
     */
    public ReorderOrReplacePlaylistsItemsRequest snapshotId(String snapshotId) {
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
