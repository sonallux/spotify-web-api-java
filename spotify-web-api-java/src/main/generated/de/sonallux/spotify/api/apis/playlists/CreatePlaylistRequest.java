package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Create Playlist request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-modify-public, playlist-modify-private</code>
 *
 * <h3>Response</h3>
 * <p>A playlist</p>
 */
public class CreatePlaylistRequest {
    private static final TypeReference<Playlist> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Create Playlist request</h3>
     * @param apiClient <p>The API client</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify user ID</a>.</p>
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
     * <p>Defaults to <code>true</code>. If <code>true</code> the playlist will be public, if <code>false</code> it will be private. To be able to create private playlists, the user must have granted the <code>playlist-modify-private</code> <a href="/documentation/general/guides/authorization-guide/#list-of-scopes">scope</a></p>
     */
    public CreatePlaylistRequest _public(boolean _public) {
        this.request.addBodyParameter("public", _public);
        return this;
    }

    /**
     * <p>Defaults to <code>false</code>. If <code>true</code> the playlist will be collaborative. <em><strong>Note</strong>: to create a collaborative playlist you must also set <code>public</code> to <code>false</code>. To create collaborative playlists you must have granted <code>playlist-modify-private</code> and <code>playlist-modify-public</code> <a href="/documentation/general/guides/authorization-guide/#list-of-scopes">scopes</a>.</em></p>
     */
    public CreatePlaylistRequest collaborative(boolean collaborative) {
        this.request.addBodyParameter("collaborative", collaborative);
        return this;
    }

    /**
     * <p>value for playlist description as displayed in Spotify Clients and in the Web API.</p>
     */
    public CreatePlaylistRequest description(String description) {
        this.request.addBodyParameter("description", description);
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Playlist> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
