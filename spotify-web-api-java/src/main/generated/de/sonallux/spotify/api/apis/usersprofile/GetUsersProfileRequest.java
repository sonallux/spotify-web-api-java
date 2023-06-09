package de.sonallux.spotify.api.apis.usersprofile;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get User's Profile request</h2>
 *
 * <h3>Response</h3>
 * <p>A user</p>
 */
public class GetUsersProfileRequest {
    private static final TypeReference<PublicUser> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get User's Profile request
     * @param apiClient <p>The API client</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify user ID</a>.</p>
     */
    public GetUsersProfileRequest(ApiClient apiClient, String userId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/users/{user_id}")
            .addPathParameter("user_id", String.valueOf(userId))
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<PublicUser> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
