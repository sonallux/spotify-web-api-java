package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Recently Played Tracks request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-recently-played</code>
 *
 * <h3>Response</h3>
 * <p>A paged set of tracks</p>
 */
public class GetRecentlyPlayedRequest {
    private static final TypeReference<CursorPaging<PlayHistory>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Recently Played Tracks request
     * @param apiClient <p>The API client</p>
     */
    public GetRecentlyPlayedRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/player/recently-played")
        ;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetRecentlyPlayedRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param after <p>A Unix timestamp in milliseconds. Returns all items after (but not including) this cursor position. If <code>after</code> is specified, <code>before</code>must not be specified.</p>
     * @return this request
     */
    public GetRecentlyPlayedRequest after(int after) {
        this.request.addQueryParameter("after", String.valueOf(after));
        return this;
    }

    /**
     * @param before <p>A Unix timestamp in milliseconds. Returns all items before (but not including) this cursor position. If <code>before</code> is specified, <code>after</code> must not be specified.</p>
     * @return this request
     */
    public GetRecentlyPlayedRequest before(int before) {
        this.request.addQueryParameter("before", String.valueOf(before));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<CursorPaging<PlayHistory>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
