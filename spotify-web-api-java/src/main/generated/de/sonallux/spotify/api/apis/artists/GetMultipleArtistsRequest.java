package de.sonallux.spotify.api.apis.artists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Several Artists request
 *
 * <h3>Response</h3>
 * <p>A set of artists</p>
 */
public class GetMultipleArtistsRequest {
    private static final TypeReference<ManyArtists> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Several Artists request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the artists. Maximum: 50 IDs.</p>
     */
    public GetMultipleArtistsRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/artists")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<ManyArtists> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
