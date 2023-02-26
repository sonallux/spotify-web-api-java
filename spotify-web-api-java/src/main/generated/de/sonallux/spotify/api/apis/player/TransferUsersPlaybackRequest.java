package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Transfer Playback request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-modify-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>Playback transferred</p>
 */
public class TransferUsersPlaybackRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Transfer Playback request
     * @param apiClient <p>The API client</p>
     * @param deviceIds <p>A JSON array containing the ID of the device on which playback should be started/transferred.<br/>For example:<code>{device_ids:[&quot;74ASZWbe4lXaubB36ztrGX&quot;]}</code><br/><em><strong>Note</strong>: Although an array is accepted, only a single device_id is currently supported. Supplying more than one will return <code>400 Bad Request</code></em></p>
     */
    public TransferUsersPlaybackRequest(ApiClient apiClient, java.util.List<String> deviceIds) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/me/player")
            .addBodyParameter("device_ids", deviceIds)
        ;
    }

    /**
     * @param play <p><strong>true</strong>: ensure playback happens on new device.<br/><strong>false</strong> or not provided: keep the current playback state.</p>
     * @return this request
     */
    public TransferUsersPlaybackRequest play(boolean play) {
        this.request.addBodyParameter("play", play);
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
