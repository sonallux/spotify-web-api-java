package de.sonallux.spotify.api.apis.tracks;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Tracks' Audio Features request
 *
 * <h3>Response</h3>
 * <p>A set of audio features</p>
 */
public class GetSeveralAudioFeaturesRequest {
    private static final TypeReference<ManyAudioFeatures> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Tracks' Audio Features request</h3>
     * @param apiClient <p>The API client</p>
     * @param ids <p>A comma-separated list of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>for the tracks. Maximum: 100 IDs.</p>
     */
    public GetSeveralAudioFeaturesRequest(ApiClient apiClient, String ids) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/audio-features")
            .addQueryParameter("ids", String.valueOf(ids))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<ManyAudioFeatures> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
