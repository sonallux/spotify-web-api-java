package de.sonallux.spotify.api.apis.library;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get User's Saved Shows request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-read</code>
 *
 * <h3>Response</h3>
 * <p>Pages of saved shows</p>
 */
public class GetUsersSavedShowsRequest {
    private static final TypeReference<Paging<SavedShow>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get User's Saved Shows request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetUsersSavedShowsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/shows")
        ;
    }

    /**
     * <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     */
    public GetUsersSavedShowsRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     */
    public GetUsersSavedShowsRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Paging<SavedShow>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
