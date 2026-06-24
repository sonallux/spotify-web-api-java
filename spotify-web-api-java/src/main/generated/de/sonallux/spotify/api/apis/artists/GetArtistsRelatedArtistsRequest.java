package de.sonallux.spotify.api.apis.artists;

import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;
import tools.jackson.core.type.TypeReference;

/**
 * <h2>Get Artist's Related Artists request</h2>
 *
 * <h3>Response</h3>
 * <p>A set of artists</p>
 * @deprecated see <a href="https://developer.spotify.com/community">the latest blog posts from Spotify</a>
 */
@Deprecated
@NullMarked
public class GetArtistsRelatedArtistsRequest {
    private static final TypeReference<ManyArtists> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Artist's Related Artists request
     * @param apiClient <p>The API client</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the artist.</p>
     */
    public GetArtistsRelatedArtistsRequest(ApiClient apiClient, String id) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/artists/{id}/related-artists")
            .addPathParameter("id", String.valueOf(id))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<ManyArtists> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
