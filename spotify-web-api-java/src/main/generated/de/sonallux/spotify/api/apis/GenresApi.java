package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.genres.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Genres
 */
@NullMarked
@RequiredArgsConstructor
public class GenresApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Available Genre Seeds</h4>
     * <p>Retrieve a list of available genres seed parameter values for <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendations">recommendations</a>.</p>
     * @return a {@link GetRecommendationGenresRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetRecommendationGenresRequest getRecommendationGenres() {
        return new GetRecommendationGenresRequest(apiClient);
    }
}
