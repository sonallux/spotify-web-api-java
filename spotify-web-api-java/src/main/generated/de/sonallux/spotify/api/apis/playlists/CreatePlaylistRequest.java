package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Create Playlist request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A playlist</p>
 */
@NullMarked
public class CreatePlaylistRequest {
    private static final TypeReference<Playlist> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Create Playlist request
     * @param apiClient <p>The API client</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify user ID</a>.</p>
     * @param name <p>The name for the new playlist, for example <code>&quot;Your Coolest Playlist&quot;</code>. This name does not need to be unique; a user may have several playlists with the same name.</p>
     */
    public CreatePlaylistRequest(ApiClient apiClient, String userId, String name) {
        this.apiClient = apiClient;
        this.request = new Request("POST", "/users/{user_id}/playlists")
            .addPathParameter("user_id", String.valueOf(userId))
            .addBodyParameter("name", name)
        ;
    }

    /**
     * @param _public <p>Defaults to <code>true</code>. The playlist's public/private status (if it should be added to the user's profile or not): <code>true</code> the playlist will be public, <code>false</code> the playlist will be private. To be able to create private playlists, the user must have granted the <code>playlist-modify-private</code> <a href="https://developer.spotify.com/documentation/web-api/concepts/scopes/#list-of-scopes">scope</a>. For more about public/private status, see <a href="https://developer.spotify.com/documentation/web-api/concepts/playlists">Working with Playlists</a></p>
     * @return this request
     */
    public CreatePlaylistRequest _public(boolean _public) {
        this.request.addBodyParameter("public", _public);
        return this;
    }

    /**
     * @param collaborative <p>Defaults to <code>false</code>. If <code>true</code> the playlist will be collaborative. <em><strong>Note</strong>: to create a collaborative playlist you must also set <code>public</code> to <code>false</code>. To create collaborative playlists you must have granted <code>playlist-modify-private</code> and <code>playlist-modify-public</code> <a href="https://developer.spotify.com/documentation/web-api/concepts/scopes/#list-of-scopes">scopes</a>.</em></p>
     * @return this request
     */
    public CreatePlaylistRequest collaborative(boolean collaborative) {
        this.request.addBodyParameter("collaborative", collaborative);
        return this;
    }

    /**
     * @param description <p>value for playlist description as displayed in Spotify Clients and in the Web API.</p>
     * @return this request
     */
    public CreatePlaylistRequest description(String description) {
        this.request.addBodyParameter("description", description);
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Playlist> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
