package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Add Items to Playlist request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A snapshot ID for the playlist</p>
 */
@NullMarked
public class AddTracksToPlaylistRequest {
    private static final TypeReference<PlaylistSnapshotId> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Add Items to Playlist request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @param uris <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify URIs</a> to add. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;,&quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;, &quot;spotify:episode:512ojhOuo1ktJprKbVcKyQ&quot;]}</code><br/>A maximum of 100 items can be added in one request. <em><strong>Note</strong>: if the <code>uris</code> parameter is present in the query string, any URIs listed here in the body will be ignored.</em></p>
     */
    public AddTracksToPlaylistRequest(ApiClient apiClient, String playlistId, java.util.List<String> uris) {
        this.apiClient = apiClient;
        this.request = new Request("POST", "/playlists/{playlist_id}/tracks")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addBodyParameter("uris", uris)
        ;
    }

    /**
     * @param position <p>The position to insert the items, a zero-based index. For example, to insert the items in the first position: <code>position=0</code> ; to insert the items in the third position: <code>position=2</code>. If omitted, the items will be appended to the playlist. Items are added in the order they appear in the uris array. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;,&quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;], &quot;position&quot;: 3}</code></p>
     * @return this request
     */
    public AddTracksToPlaylistRequest position(int position) {
        this.request.addBodyParameter("position", position);
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
