package de.sonallux.spotify.api.apis.browse;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Available Genre Seeds request
 *
 * <h3>Response</h3>
 * <p>A set of genres</p>
 */
public class GetRecommendationGenresRequest {
    private static final TypeReference<ManyGenres> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Available Genre Seeds request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetRecommendationGenresRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/recommendations/available-genre-seeds")
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<ManyGenres> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
