package de.sonallux.spotify.api.apis.markets;

import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;
import tools.jackson.core.type.TypeReference;

/**
 * <h2>Get Available Markets request</h2>
 *
 * <h3>Response</h3>
 * <p>A markets object with an array of country codes</p>
 * @deprecated see <a href="https://developer.spotify.com/community">the latest blog posts from Spotify</a>
 */
@Deprecated
@NullMarked
public class GetAvailableMarketsRequest {
    private static final TypeReference<Markets> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Available Markets request
     * @param apiClient <p>The API client</p>
     */
    public GetAvailableMarketsRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/markets")
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Markets> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
