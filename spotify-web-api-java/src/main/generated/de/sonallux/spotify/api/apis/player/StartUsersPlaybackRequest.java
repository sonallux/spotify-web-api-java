package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Start/Resume Playback request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-modify-playback-state</code>
 *
 * <h3>Response</h3>
 * <p>Playback started</p>
 */
public class StartUsersPlaybackRequest {
    private static final TypeReference<Void> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Start/Resume Playback request
     * @param apiClient <p>The API client</p>
     */
    public StartUsersPlaybackRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("PUT", "/me/player/play")
        ;
    }

    /**
     * @param deviceId <p>The id of the device this command is targeting. If not supplied, the user's currently active device is the target.</p>
     * @return this request
     */
    public StartUsersPlaybackRequest deviceId(String deviceId) {
        this.request.addQueryParameter("device_id", String.valueOf(deviceId));
        return this;
    }

    /**
     * @param contextUri <p>Optional. Spotify URI of the context to play. Valid contexts are albums, artists &amp; playlists. <code>{context_uri:&quot;spotify:album:1Je1IMUlBXcx1Fz0WE7oPT&quot;}</code></p>
     * @return this request
     */
    public StartUsersPlaybackRequest contextUri(String contextUri) {
        this.request.addBodyParameter("context_uri", contextUri);
        return this;
    }

    /**
     * @param uris <p>Optional. A JSON array of the Spotify track URIs to play. For example: <code>{&quot;uris&quot;: [&quot;spotify:track:4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;]}</code></p>
     * @return this request
     */
    public StartUsersPlaybackRequest uris(java.util.List<String> uris) {
        this.request.addBodyParameter("uris", uris);
        return this;
    }

    /**
     * @param offset <p>Optional. Indicates from where in the context playback should start. Only available when context_uri corresponds to an album or playlist object &quot;position&quot; is zero based and can’t be negative. Example: <code>&quot;offset&quot;: {&quot;position&quot;: 5}</code>&quot;uri&quot; is a string representing the uri of the item to start at. Example: <code>&quot;offset&quot;: {&quot;uri&quot;: &quot;spotify:track:1301WleyT98MSxVHPZCA6M&quot;}</code></p>
     * @return this request
     */
    public StartUsersPlaybackRequest offset(java.util.Map<String, Object> offset) {
        this.request.addBodyParameter("offset", offset);
        return this;
    }

    /**
     * @param positionMs <p>Indicates from what position to start playback. Must be a positive number. Passing in a position that is greater than the length of the track will cause the player to start playing the next song.</p>
     * @return this request
     */
    public StartUsersPlaybackRequest positionMs(int positionMs) {
        this.request.addBodyParameter("position_ms", positionMs);
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
