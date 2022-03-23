package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Add Custom Playlist Cover Image request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>ugc-image-upload, playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>Image uploaded</p>
 */
public class UploadCustomPlaylistCoverRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Add Custom Playlist Cover Image request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     * @param base64Image <p>The new cover image of the playlist as a Base64 encoded JPEG image. Maximum payload size is 256KB.</p>
     */
    public UploadCustomPlaylistCoverRequest(ApiClient apiClient, String playlistId, String base64Image) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}/images")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
            .withRawBody(okhttp3.RequestBody.create(base64Image, okhttp3.MediaType.get("image/jpeg")))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
