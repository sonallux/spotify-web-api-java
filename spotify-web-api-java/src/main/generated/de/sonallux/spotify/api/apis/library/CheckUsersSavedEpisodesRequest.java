package de.sonallux.spotify.api.apis.library;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Check User's Saved Episodes request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-library-read</code>
 *
 * <h3>Response</h3>
 * <p>Array of booleans</p>
 */
public class CheckUsersSavedEpisodesRequest {
    private static final TypeReference<java.util.List<Boolean>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Check User's Saved Episodes request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     */
    public CheckUsersSavedEpisodesRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/episodes/contains")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<java.util.List<Boolean>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
