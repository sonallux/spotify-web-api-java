package de.sonallux.spotify.api.apis.users;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;
import org.jspecify.annotations.NullMarked;

/**
 * <h2>Get Current User's Profile request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>user-read-private, user-read-email</code>
 *
 * <h3>Response</h3>
 * <p>A user</p>
 */
@NullMarked
public class GetCurrentUsersProfileRequest {
    private static final TypeReference<PrivateUser> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Current User's Profile request
     * @param apiClient <p>The API client</p>
     */
    public GetCurrentUsersProfileRequest(ApiClient apiClient) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/me")
        ;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<PrivateUser> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
