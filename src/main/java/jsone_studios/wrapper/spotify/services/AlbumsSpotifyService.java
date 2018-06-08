package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.Album;
import jsone_studios.wrapper.spotify.models.Albums;
import jsone_studios.wrapper.spotify.models.Pager;
import jsone_studios.wrapper.spotify.models.Track;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface AlbumsSpotifyService
{
    /**
     * Get Spotify catalog information for a single album.
     *
     * @param albumId The Spotify ID for the album.
     * @return Requested album information
     * @see <a href="https://developer.spotify.com/web-api/get-album/">Get an Album</a>
     */
    @GET("albums/{id}")
    Call<Album> getAlbum(@Path("id") String albumId);

    /**
     * Get Spotify catalog information for a single album.
     *
     * @param albumId The Spotify ID for the album.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-album/">endpoint documentation</a>
     * @return Requested album information
     * @see <a href="https://developer.spotify.com/web-api/get-album/">Get an Album</a>
     */
    @GET("albums/{id}")
    Call<Album> getAlbum(@Path("id") String albumId, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
     *
     * @param albumIds A comma-separated list of the Spotify IDs for the albums
     * @return Object whose key is "albums" and whose value is an array of album objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-albums/">Get Several Albums</a>
     */
    @GET("albums")
    Call<Albums> getAlbums(@Query("ids") String albumIds);

    /**
     * Get Spotify catalog information for multiple albums identified by their Spotify IDs.
     *
     * @param albumIds A comma-separated list of the Spotify IDs for the albums
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-several-albums/">endpoint documentation</a>
     * @return Object whose key is "albums" and whose value is an array of album objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-albums/">Get Several Albums</a>
     */
    @GET("albums")
    Call<Albums> getAlbums(@Query("ids") String albumIds, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about an album’s tracks.
     *
     * @param albumId The Spotify ID for the album.
     * @return List of simplified album objects wrapped in a Pager object
     * @see <a href="https://developer.spotify.com/web-api/get-albums-tracks/">Get an Album’s Tracks</a>
     */
    @GET("albums/{id}/tracks")
    Call<Pager<Track>> getAlbumTracks(@Path("id") String albumId);

    /**
     * Get Spotify catalog information about an album’s tracks.
     *
     * @param albumId The Spotify ID for the album.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-albums-tracks/">endpoint documentation</a>
     * @return List of simplified album objects wrapped in a Pager object
     * @see <a href="https://developer.spotify.com/web-api/get-albums-tracks/">Get an Album’s Tracks</a>
     */
    @GET("albums/{id}/tracks")
    Call<Pager<Track>> getAlbumTracks(@Path("id") String albumId, @QueryMap Map<String, Object> options);

}
