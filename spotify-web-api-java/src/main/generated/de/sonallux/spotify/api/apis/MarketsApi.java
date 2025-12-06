package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.markets.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Markets
 */
@NullMarked
@RequiredArgsConstructor
public class MarketsApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Available Markets</h4>
     * <p>Get the list of markets where Spotify is available.</p>
     * @return a {@link GetAvailableMarketsRequest} object to build and execute the request
     */
    public GetAvailableMarketsRequest getAvailableMarkets() {
        return new GetAvailableMarketsRequest(apiClient);
    }
}
