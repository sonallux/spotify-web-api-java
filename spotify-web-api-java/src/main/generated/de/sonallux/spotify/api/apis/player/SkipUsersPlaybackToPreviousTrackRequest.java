package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Skip To Previous request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-modify-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>Command sent</p>
 */
@NullMarked
public class SkipUsersPlaybackToPreviousTrackRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Skip To Previous request
     * @param apiClient <p>The API client</p>
     */
    public SkipUsersPlaybackToPreviousTrackRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("POST", "/me/player/previous")
        ;
    }

    /**
     * @param deviceId <p>The id of the device this command is targeting. If not supplied, the user's currently active device is the target.</p>
     * @return this request
     */
    public SkipUsersPlaybackToPreviousTrackRequest deviceId(String deviceId) {
        this.request.addQueryParameter("device_id", String.valueOf(deviceId));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Void> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
