package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get User's Playlists request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-read-private, playlist-read-collaborative</code>
 *
 * <h3>Response</h3>
 * <p>Pages of playlists</p>
 */
public class GetListUsersPlaylistsRequest {
    private static final TypeReference<Paging<SimplifiedPlaylist>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get User's Playlists request</h3>
     * @param apiClient <p>The API client</p>
     * @param userId <p>The user's <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify user ID</a>.</p>
     */
    public GetListUsersPlaylistsRequest(ApiClient apiClient, String userId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/users/{user_id}/playlists")
            .addPathParameter("user_id", String.valueOf(userId))
        ;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetListUsersPlaylistsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first playlist to return. Default: 0 (the first object). Maximum offset: 100.000. Use with <code>limit</code> to get the next set of playlists.</p>
     */
    public GetListUsersPlaylistsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Paging<SimplifiedPlaylist>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
