package de.sonallux.spotify.api.apis.users;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Followed Artists request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-follow-read</code>
 *
 * <h3>Response</h3>
 * <p>A paged set of artists</p>
 */
public class GetFollowedRequest {
    private static final TypeReference<CursorPagedArtists> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Followed Artists request
     * @param apiClient <p>The API client</p>
     * @param type <p>The ID type: currently only <code>artist</code> is supported.</p>
     */
    public GetFollowedRequest(ApiClient apiClient, String type) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/following")
            .addQueryParameter("type", String.valueOf(type))
        ;
    }

    /**
     * @param after <p>The last artist ID retrieved from the previous request.</p>
     * @return this request
     */
    public GetFollowedRequest after(String after) {
        this.request.addQueryParameter("after", String.valueOf(after));
        return this;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetFollowedRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<CursorPagedArtists> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
