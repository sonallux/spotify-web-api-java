package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Current User's Playlists request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-read-private</code>
 *
 * <h3>Response</h3>
 * <p>A paged set of playlists</p>
 */
public class GetListOfCurrentUsersPlaylistsRequest {
    private static final TypeReference<Paging<SimplifiedPlaylist>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Current User's Playlists request
     * @param apiClient <p>The API client</p>
     */
    public GetListOfCurrentUsersPlaylistsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/playlists")
        ;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetListOfCurrentUsersPlaylistsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>'The index of the first playlist to return. Default: 0 (the first object). Maximum offset: 100.000. Use with <code>limit</code> to get the next set of playlists.'</p>
     * @return this request
     */
    public GetListOfCurrentUsersPlaylistsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Paging<SimplifiedPlaylist>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
