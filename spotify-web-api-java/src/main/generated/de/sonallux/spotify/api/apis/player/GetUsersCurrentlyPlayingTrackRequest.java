package de.sonallux.spotify.api.apis.player;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Get Currently Playing Track request
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-currently-playing</code>
 *
 * <h3>Response</h3>
 * <p>Information about the currently playing track</p>
 */
public class GetUsersCurrentlyPlayingTrackRequest {
    private static final TypeReference<CurrentlyPlaying> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Get Currently Playing Track request</h3>
     * @param apiClient <p>The API client</p>
     */
    public GetUsersCurrentlyPlayingTrackRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me/player/currently-playing")
        ;
        this.additionalTypes("track,episode");
    }

    /**
     * <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     */
    public GetUsersCurrentlyPlayingTrackRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * <p>A comma-separated list of item types that your client supports besides the default <code>track</code> type. Valid types are: <code>track</code> and <code>episode</code>.<br><em><strong>Note</strong>: This parameter was introduced to allow existing clients to maintain their current behaviour and might be deprecated in the future.</em><br>In addition to providing this parameter, make sure that your client properly handles cases of new types in the future by checking against the <code>type</code> field of each object.</p>
     */
    public GetUsersCurrentlyPlayingTrackRequest additionalTypes(String additionalTypes) {
        this.request.addQueryParameter("additional_types", String.valueOf(additionalTypes));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<CurrentlyPlaying> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
