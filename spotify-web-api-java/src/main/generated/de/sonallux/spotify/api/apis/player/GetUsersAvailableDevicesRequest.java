package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Get Available Devices request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>A set of devices</p>
 */
@NullMarked
public class GetUsersAvailableDevicesRequest {
    private static final TypeReference<ManyDevices> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Available Devices request
     * @param apiClient <p>The API client</p>
     */
    public GetUsersAvailableDevicesRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/player/devices")
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<ManyDevices> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
