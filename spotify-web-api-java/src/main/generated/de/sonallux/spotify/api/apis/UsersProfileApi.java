package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.usersprofile.*;
import lombok.RequiredArgsConstructor;

/**
 * Users Profile
 */
@RequiredArgsConstructor
public class UsersProfileApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Current User's Profile</h4>
     * <p>Get detailed profile information about the current user (including the current user's username).</p>
     * @return a {@link GetCurrentUsersProfileRequest} object to build and execute the request
     */
    public GetCurrentUsersProfileRequest getCurrentUsersProfile() {
        return new GetCurrentUsersProfileRequest(apiClient);
    }

    /**
     * <h4>Get User's Profile</h4>
     * <p>Get public profile information about a Spotify user.</p>
     * @param userId <p>The user's <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify user ID</a>.</p>
     * @return a {@link GetUsersProfileRequest} object to build and execute the request
     */
    public GetUsersProfileRequest getUsersProfile(String userId) {
        return new GetUsersProfileRequest(apiClient, userId);
    }
}
