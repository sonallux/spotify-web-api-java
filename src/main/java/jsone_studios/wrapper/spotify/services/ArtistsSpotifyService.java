package jsone_studios.wrapper.spotify.services;

import jsone_studios.wrapper.spotify.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ArtistsSpotifyService
{
    /**
     * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
     *
     * @param artistId The Spotify ID for the artist.
     * @return Requested artist information
     * @see <a href="https://developer.spotify.com/web-api/get-artist/">Get an Artist</a>
     */
    @GET("/artists/{id}")
    Call<Artist> getArtist(@Path("id") String artistId);

    /**
     * Get Spotify catalog information for several artists based on their Spotify IDs.
     *
     * @param artistIds A comma-separated list of the Spotify IDs for the artists
     * @return An object whose key is "artists" and whose value is an array of artist objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-artists/">Get Several Artists</a>
     */
    @GET("/artists")
    Call<Artists> getArtists(@Query("ids") String artistIds);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @return An array of simplified album objects wrapped in a paging object.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    Call<Pager<Album>> getArtistAlbums(@Path("id") String artistId);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-artists-albums/">endpoint documentation</a>
     * @return An array of simplified album objects wrapped in a paging object.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    Call<Pager<Album>> getArtistAlbums(@Path("id") String artistId, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about an artist’s top tracks by country.
     *
     * @param artistId The Spotify ID for the artist.
     * @param country  The country: an ISO 3166-1 alpha-2 country code.
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-top-tracks/">Get an Artist’s Top Tracks</a>
     */
    @GET("/artists/{id}/top-tracks")
    Call<Tracks> getArtistTopTrack(@Path("id") String artistId, @Query("country") String country);

    /**
     * Get Spotify catalog information about artists similar to a given artist.
     *
     * @param artistId The Spotify ID for the artist.
     * @return An object whose key is "artists" and whose value is an array of artist objects.
     * @see <a href="https://developer.spotify.com/web-api/get-related-artists/">Get an Artist’s Related Artists</a>
     */
    @GET("/artists/{id}/related-artists")
    Call<Artists> getRelatedArtists(@Path("id") String artistId);

}
