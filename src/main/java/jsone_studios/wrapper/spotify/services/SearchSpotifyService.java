package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.AlbumsPager;
import jsone_studios.wrapper.spotify.models.ArtistsPager;
import jsone_studios.wrapper.spotify.models.PlaylistsPager;
import jsone_studios.wrapper.spotify.models.TracksPager;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface SearchSpotifyService
{
    /**
     * Get Spotify catalog information about tracks that match a keyword string.
     *
     * @param q The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=track")
    Call<TracksPager> searchTracks(@Query("q") String q);

    /**
     * Get Spotify catalog information about tracks that match a keyword string.
     *
     * @param q       The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/search-item/">endpoint documentation</a>
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=track")
    Call<TracksPager> searchTracks(@Query("q") String q, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about artists that match a keyword string.
     *
     * @param q The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=artist")
    Call<ArtistsPager> searchArtists(@Query("q") String q);

    /**
     * Get Spotify catalog information about artists that match a keyword string.
     *
     * @param q       The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/search-item/">endpoint documentation</a>
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=artist")
    Call<ArtistsPager> searchArtists(@Query("q") String q, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about albums that match a keyword string.
     *
     * @param q The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=album")
    Call<AlbumsPager> searchAlbums(@Query("q") String q);

    /**
     * Get Spotify catalog information about albums that match a keyword string.
     *
     * @param q       The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/search-item/">endpoint documentation</a>
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=album")
    Call<AlbumsPager> searchAlbums(@Query("q") String q, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about playlists that match a keyword string.
     *
     * @param q The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=playlist")
    Call<PlaylistsPager> searchPlaylists(@Query("q") String q);

    /**
     * Get Spotify catalog information about playlists that match a keyword string.
     *
     * @param q       The search query's keywords (and optional field filters and operators), for example "roadhouse+blues"
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/search-item/">endpoint documentation</a>
     * @return A paginated list of results
     * @see <a href="https://developer.spotify.com/web-api/search-item/">Search for an Item</a>
     */
    @GET("search?type=playlist")
    Call<PlaylistsPager> searchPlaylists(@Query("q") String q, @QueryMap Map<String, Object> options);

}
