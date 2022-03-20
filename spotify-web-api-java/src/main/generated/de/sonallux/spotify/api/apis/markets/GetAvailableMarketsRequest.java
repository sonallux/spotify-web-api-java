package de.sonallux.spotify.api.apis.markets;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Available Markets request
 *
 * <h3>Response</h3>
 * <p>A markets object with an array of country codes</p>
 */
public class GetAvailableMarketsRequest {
    private static final TypeReference<Markets> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Available Markets request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetAvailableMarketsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/markets")
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Markets> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
