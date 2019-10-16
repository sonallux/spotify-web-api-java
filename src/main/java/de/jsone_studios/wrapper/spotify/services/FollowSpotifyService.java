package de.jsone_studios.wrapper.spotify.services;

import de.jsone_studios.wrapper.spotify.models.ArtistsCursorPager;
import de.jsone_studios.wrapper.spotify.models.PlaylistFollowPrivacy;
import de.jsone_studios.wrapper.spotify.models.Result;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface FollowSpotifyService
{
    /**
     * Check to see if the current user is following one or more other Spotify users.
     *
     * @param ids A comma-separated list of the Spotify IDs for the users
     * @return An array with boolean values indicating whether the users are followed
     * @see <a href="https://developer.spotify.com/web-api/check-current-user-follows/">Check if Current User Follows Artists or Users</a>
     */
    @GET("me/following/contains?type=user")
    Call<Boolean[]> isFollowingUsers(@Query("ids") String ids);

    /**
     * Check to see if the current user is following one or more other Spotify artists.
     *
     * @param ids A comma-separated list of the Spotify IDs for the artists
     * @return An array with boolean values indicating whether the artists are followed
     * @see <a href="https://developer.spotify.com/web-api/check-current-user-follows/">Check if Current User Follows Artists or Users</a>
     */
    @GET("me/following/contains?type=artist")
    Call<Boolean[]> isFollowingArtists(@Query("ids") String ids);

    /**
     * Check to see if one or more Spotify users are following a specified playlist.
     *
     * @param playlistId The Spotify ID of the playlist.
     * @param ids        A comma-separated list of the Spotify IDs for the users
     * @return An array with boolean values indicating whether the playlist is followed by the users
     * @see <a href="https://developer.spotify.com/web-api/check-user-following-playlist/">Check if Users Follow a Playlist</a>
     */
    @GET("playlists/{playlist_id}/followers/contains")
    Call<Boolean[]> areFollowingPlaylist(@Path("playlist_id") String playlistId, @Query("ids") String ids);

    /**
     * Add the current user as a follower of one or more Spotify users.
     *
     * @param ids A comma-separated list of the Spotify IDs for the users
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-artists-users/">Follow Artists or Users</a>
     */
    @PUT("me/following?type=user")
    Call<Result> followUsers(@Query("ids") String ids);

    /**
     * Add the current user as a follower of one or more Spotify artists.
     *
     * @param ids A comma-separated list of the Spotify IDs for the artists
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-artists-users/">Follow Artists or Users</a>
     */
    @PUT("me/following?type=artist")
    Call<Result> followArtists(@Query("ids") String ids);

    /**
     * Add the current user as a follower of a playlist.
     *
     * @param playlistId The Spotify ID of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-playlist/">Follow a Playlist</a>
     */
    @PUT("playlists/{playlist_id}/followers")
    Call<Result> followPlaylist(@Path("playlist_id") String playlistId);

    /**
     * Add the current user as a follower of a playlist.
     *
     * @param playlistId            The Spotify ID of the playlist
     * @param playlistFollowPrivacy The privacy state of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/follow-playlist/">Follow a Playlist</a>
     */
    @PUT("playlists/{playlist_id}/followers")
    Call<Result> followPlaylist(@Path("playlist_id") String playlistId, @Body PlaylistFollowPrivacy playlistFollowPrivacy);

    /**
     * Get the current user's followed artists.
     *
     * @return Object containing a list of artists that user follows wrapped in a cursor object.
     * @see <a href="https://developer.spotify.com/web-api/get-followed-artists/">Get User's Followed Artists</a>
     */
    @GET("me/following?type=artist")
    Call<ArtistsCursorPager> getFollowedArtists();

    /**
     * Get the current user's followed artists.
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-followed-artists/">endpoint documentation</a>
     * @return Object containing a list of artists that user follows wrapped in a cursor object.
     * @see <a href="https://developer.spotify.com/web-api/get-followed-artists/">Get User's Followed Artists</a>
     */
    @GET("me/following?type=artist")
    Call<ArtistsCursorPager> getFollowedArtists(@QueryMap Map<String, Object> options);

    /**
     * Remove the current user as a follower of one or more Spotify users.
     *
     * @param ids A comma-separated list of the Spotify IDs for the users
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/unfollow-artists-users/">Unfollow Artists or Users</a>
     */
    @DELETE("me/following?type=user")
    Call<Result> unfollowUsers(@Query("ids") String ids);

    /**
     * Remove the current user as a follower of one or more Spotify artists.
     *
     * @param ids A comma-separated list of the Spotify IDs for the artists
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/unfollow-artists-users/">Unfollow Artists or Users</a>
     */
    @DELETE("me/following?type=artist")
    Call<Result> unfollowArtists(@Query("ids") String ids);

    /**
     * Unfollow a Playlist
     *
     * @param playlistId The Spotify ID of the playlist
     * @return An empty result
     * @see <a href="https://developer.spotify.com/web-api/unfollow-playlist/">Unfollow a Playlist</a>
     */
    @DELETE("playlists/{playlist_id}/followers")
    Call<Result> unfollowPlaylist(@Path("playlist_id") String playlistId);
}
