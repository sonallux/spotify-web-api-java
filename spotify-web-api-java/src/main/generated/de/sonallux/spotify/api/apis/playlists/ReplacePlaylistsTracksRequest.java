package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#endpoint-reorder-or-replace-playlists-tracks">Replace items in a playlist request</a>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-private, playlist-modify-public</code>
 *
 * <h3>Response</h3>
 * <p>On a successful <strong>replace</strong> operation, the HTTP status code in the response header is <code>201</code>
 * Created.</p>
 * <p>On error, the header status code is an <a href="https://developer.spotify.com/documentation/web-api/#response-status-codes">error code</a>,
 * the response body contains an <a href="https://developer.spotify.com/documentation/web-api/#response-schema">error object</a>,
 * and the existing playlist is unmodified.
 * Trying to set an item when you do not have the user's authorization returns error <code>403</code> Forbidden.</p>
 */
public class ReplacePlaylistsTracksRequest {
    private static final TypeReference<SnapshotId> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Replace items in a playlist request</h3>
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     * @param uris <p>A comma-separated list of <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify URIs</a> to set, can be track or episode URIs. For example: <code>uris=spotify:track:4iV5W9uYEdYUVa79Axb7Rh,spotify:track:1301WleyT98MSxVHPZCA6M,spotify:episode:512ojhOuo1ktJprKbVcKyQ</code><br>A maximum of 100 items can be set in one request.</p>
     */
    public ReplacePlaylistsTracksRequest(ApiClient apiClient, String playlistId, java.util.List<String> uris) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}/tracks")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .addBodyParameter("uris", uris)
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<SnapshotId> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
