package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Change Playlist Details request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>Playlist updated</p>
 */
public class ChangePlaylistDetailsRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Change Playlist Details request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     */
    public ChangePlaylistDetailsRequest(ApiClient apiClient, String playlistId) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/playlists/{playlist_id}")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
        ;
    }

    /**
     * @param name <p>The new name for the playlist, for example <code>&quot;My New Playlist Title&quot;</code></p>
     * @return this request
     */
    public ChangePlaylistDetailsRequest name(String name) {
        this.request.addBodyParameter("name", name);
        return this;
    }

    /**
     * @param _public <p>If <code>true</code> the playlist will be public, if <code>false</code> it will be private.</p>
     * @return this request
     */
    public ChangePlaylistDetailsRequest _public(boolean _public) {
        this.request.addBodyParameter("public", _public);
        return this;
    }

    /**
     * @param collaborative <p>If <code>true</code>, the playlist will become collaborative and other users will be able to modify the playlist in their Spotify client. <br/><em><strong>Note</strong>: You can only set <code>collaborative</code> to <code>true</code> on non-public playlists.</em></p>
     * @return this request
     */
    public ChangePlaylistDetailsRequest collaborative(boolean collaborative) {
        this.request.addBodyParameter("collaborative", collaborative);
        return this;
    }

    /**
     * @param description <p>Value for playlist description as displayed in Spotify Clients and in the Web API.</p>
     * @return this request
     */
    public ChangePlaylistDetailsRequest description(String description) {
        this.request.addBodyParameter("description", description);
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
