package de.sonallux.spotify.api.apis.tracks;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Track's Audio Analysis request
 *
 * <h3>Response</h3>
 * <p>Audio analysis for one track</p>
 */
public class GetAudioAnalysisRequest {
    private static final TypeReference<AudioAnalysis> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Track's Audio Analysis request</h3>
     * @param apiClient <p>The API client</p>
     * @param id <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a>for the track.</p>
     */
    public GetAudioAnalysisRequest(ApiClient apiClient, String id) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/audio-analysis/{id}")
            .addPathParameter("id", String.valueOf(id))
        ;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<AudioAnalysis> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
