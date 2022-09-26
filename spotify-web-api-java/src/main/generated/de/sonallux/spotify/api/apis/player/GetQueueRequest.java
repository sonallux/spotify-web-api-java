package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get the User's Queue request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>Information about the queue</p>
 */
public class GetQueueRequest {
    private static final TypeReference<Queue> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get the User's Queue request
     * @param apiClient <p>The API client</p>
     */
    public GetQueueRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/player/queue")
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Queue> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
