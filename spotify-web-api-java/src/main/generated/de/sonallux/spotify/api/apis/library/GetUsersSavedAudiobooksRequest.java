package de.sonallux.spotify.api.apis.library;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get User's Saved Audiobooks request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-read</code>
 *
 * <h3>Response</h3>
 * <p>Pages of saved audiobooks</p>
 */
public class GetUsersSavedAudiobooksRequest {
    private static final TypeReference<Paging<SavedAudiobook>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get User's Saved Audiobooks request
     * @param apiClient <p>The API client</p>
     */
    public GetUsersSavedAudiobooksRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/audiobooks")
        ;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 50.</p>
     * @return this request
     */
    public GetUsersSavedAudiobooksRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     * @return this request
     */
    public GetUsersSavedAudiobooksRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Paging<SavedAudiobook>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
