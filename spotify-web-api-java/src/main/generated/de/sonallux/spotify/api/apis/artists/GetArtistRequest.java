package de.sonallux.spotify.api.apis.artists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Artist request
 *
 * <h3>Response</h3>
 * <p>An artist</p>
 */
public class GetArtistRequest {
    private static final TypeReference<Artist> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Artist request</h3>
     * @param apiClient <p>The API client</p>
     * @param id <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the artist.</p>
     */
    public GetArtistRequest(ApiClient apiClient, String id) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/artists/{id}")
            .addPathParameter("id", String.valueOf(id))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<Artist> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
