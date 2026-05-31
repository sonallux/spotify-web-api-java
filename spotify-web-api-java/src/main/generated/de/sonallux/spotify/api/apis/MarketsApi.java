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
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetAvailableMarketsRequest getAvailableMarkets() {
        return new GetAvailableMarketsRequest(apiClient);
    }
}
