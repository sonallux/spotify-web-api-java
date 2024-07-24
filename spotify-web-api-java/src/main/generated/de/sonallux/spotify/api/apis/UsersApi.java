package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.users.*;
import lombok.RequiredArgsConstructor;

/**
 * Users
 */
@RequiredArgsConstructor
public class UsersApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check If User Follows Artists or Users</h4>
     * <p>Check to see if the current user is following one or more artists or other Spotify users.</p>
     * @param type <p>The ID type: either <code>artist</code> or <code>user</code>.</p>
     * @param ids <p>A comma-separated list of the artist or the user <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> to check. For example: <code>ids=74ASZWbe4lXaubB36ztrGX,08td7MxkoHQkXnWAYD8d6Q</code>. A maximum of 50 IDs can be sent in one request.</p>
     * @return a {@link CheckCurrentUserFollowsRequest} object to build and execute the request
     */
    public CheckCurrentUserFollowsRequest checkCurrentUserFollows(String type, String ids) {
        return new CheckCurrentUserFollowsRequest(apiClient, type, ids);
    }

    /**
     * <h4>Check if Current User Follows Playlist</h4>
     * <p>Check to see if the current user is following a specified playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link CheckIfUserFollowsPlaylistRequest} object to build and execute the request
     */
    public CheckIfUserFollowsPlaylistRequest checkIfUserFollowsPlaylist(String playlistId) {
        return new CheckIfUserFollowsPlaylistRequest(apiClient, playlistId);
    }

    /**
     * <h4>Follow Artists or Users</h4>
     * <p>Add the current user as a follower of one or more artists or other Spotify users.</p>
     * @param type <p>The ID type.</p>
     * @param ids <p>A JSON array of the artist or user <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>{ids:[&quot;74ASZWbe4lXaubB36ztrGX&quot;, &quot;08td7MxkoHQkXnWAYD8d6Q&quot;]}</code>. A maximum of 50 IDs can be sent in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link FollowArtistsUsersRequest} object to build and execute the request
     */
    public FollowArtistsUsersRequest followArtistsUsers(String type, java.util.List<String> ids) {
        return new FollowArtistsUsersRequest(apiClient, type, ids);
    }

    /**
     * <h4>Follow Playlist</h4>
     * <p>Add the current user as a follower of a playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link FollowPlaylistRequest} object to build and execute the request
     */
    public FollowPlaylistRequest followPlaylist(String playlistId) {
        return new FollowPlaylistRequest(apiClient, playlistId);
    }

    /**
     * <h4>Get Current User's Profile</h4>
     * <p>Get detailed profile information about the current user (including the current user's username).</p>
     * @return a {@link GetCurrentUsersProfileRequest} object to build and execute the request
     */
    public GetCurrentUsersProfileRequest getCurrentUsersProfile() {
        return new GetCurrentUsersProfileRequest(apiClient);
    }

    /**
     * <h4>Get Followed Artists</h4>
     * <p>Get the current user's followed artists.</p>
     * @param type <p>The ID type: currently only <code>artist</code> is supported.</p>
     * @return a {@link GetFollowedRequest} object to build and execute the request
     */
    public GetFollowedRequest getFollowed(String type) {
        return new GetFollowedRequest(apiClient, type);
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

    /**
     * <h4>Get User's Top Artists</h4>
     * <p>Get the current user's top artists based on calculated affinity.</p>
     * @return a {@link GetUsersTopArtistsRequest} object to build and execute the request
     */
    public GetUsersTopArtistsRequest getUsersTopArtists() {
        return new GetUsersTopArtistsRequest(apiClient);
    }

    /**
     * <h4>Get User's Top Tracks</h4>
     * <p>Get the current user's top tracks based on calculated affinity.</p>
     * @return a {@link GetUsersTopTracksRequest} object to build and execute the request
     */
    public GetUsersTopTracksRequest getUsersTopTracks() {
        return new GetUsersTopTracksRequest(apiClient);
    }

    /**
     * <h4>Unfollow Artists or Users</h4>
     * <p>Remove the current user as a follower of one or more artists or other Spotify users.</p>
     * @param type <p>The ID type: either <code>artist</code> or <code>user</code>.</p>
     * @param ids <p>A JSON array of the artist or user <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>{ids:[&quot;74ASZWbe4lXaubB36ztrGX&quot;, &quot;08td7MxkoHQkXnWAYD8d6Q&quot;]}</code>. A maximum of 50 IDs can be sent in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link UnfollowArtistsUsersRequest} object to build and execute the request
     */
    public UnfollowArtistsUsersRequest unfollowArtistsUsers(String type, java.util.List<String> ids) {
        return new UnfollowArtistsUsersRequest(apiClient, type, ids);
    }

    /**
     * <h4>Unfollow Playlist</h4>
     * <p>Remove the current user as a follower of a playlist.</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the playlist.</p>
     * @return a {@link UnfollowPlaylistRequest} object to build and execute the request
     */
    public UnfollowPlaylistRequest unfollowPlaylist(String playlistId) {
        return new UnfollowPlaylistRequest(apiClient, playlistId);
    }
}
