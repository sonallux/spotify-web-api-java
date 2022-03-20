package de.sonallux.spotify.api.apis.follow;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Follow Playlist request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>Playlist followed</p>
 */
public class FollowPlaylistRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Follow Playlist request</h3>
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     */
    public FollowPlaylistRequest(ApiClient apiClient, String playlistId) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}/followers")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
        ;
    }

    /**
     * <p>Defaults to <code>true</code>. If <code>true</code> the playlist will be included in user's public playlists, if <code>false</code> it will remain private.</p>
     */
    public FollowPlaylistRequest _public(boolean _public) {
        this.request.addBodyParameter("public", _public);
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
