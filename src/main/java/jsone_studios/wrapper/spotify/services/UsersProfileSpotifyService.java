package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.UserPrivate;
import jsone_studios.wrapper.spotify.models.UserPublic;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsersProfileSpotifyService
{

    /**
     * Get detailed profile information about the current user (including the current user’s username).
     *
     * @return user object (private)
     * @see <a href="https://developer.spotify.com/web-api/get-current-users-profile/">Get Current User's Profile</a>
     */
    @GET("me")
    Call<UserPrivate> getMe();

    /**
     * Get public profile information about a Spotify user.
     *
     * @return user object (public)
     * @see <a href="https://developer.spotify.com/web-api/get-users-profile/">Get a User's Profile</a>
     */
    @GET("users/{id}")
    Call<UserPublic> getUser(@Path("id") String userId);
}
