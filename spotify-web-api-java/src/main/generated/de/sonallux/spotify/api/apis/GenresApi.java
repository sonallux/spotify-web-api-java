package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.genres.*;
import lombok.RequiredArgsConstructor;

/**
 * Genres
 */
@RequiredArgsConstructor
public class GenresApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Available Genre Seeds</h4>
     * <p>Retrieve a list of available genres seed parameter values for <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendations">recommendations</a>.</p>
     * @return a {@link GetRecommendationGenresRequest} object to build and execute the request
     */
    public GetRecommendationGenresRequest getRecommendationGenres() {
        return new GetRecommendationGenresRequest(apiClient);
    }
}
