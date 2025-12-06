package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.artists.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Artists
 */
@NullMarked
@RequiredArgsConstructor
public class ArtistsApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Artist</h4>
     * <p>Get Spotify catalog information for a single artist identified by their unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the artist.</p>
     * @return a {@link GetArtistRequest} object to build and execute the request
     */
    public GetArtistRequest getArtist(String id) {
        return new GetArtistRequest(apiClient, id);
    }

    /**
     * <h4>Get Artist's Albums</h4>
     * <p>Get Spotify catalog information about an artist's albums.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the artist.</p>
     * @return a {@link GetArtistsAlbumsRequest} object to build and execute the request
     */
    public GetArtistsAlbumsRequest getArtistsAlbums(String id) {
        return new GetArtistsAlbumsRequest(apiClient, id);
    }

    /**
     * <h4>Get Artist's Related Artists</h4>
     * <p>Get Spotify catalog information about artists similar to a given artist. Similarity is based on analysis of the Spotify community's listening history.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the artist.</p>
     * @return a {@link GetArtistsRelatedArtistsRequest} object to build and execute the request
     * @deprecated see <a href="https://developer.spotify.com/blog/2024-11-27-changes-to-the-web-api">this blog post from Spotify</a>
     */
    public GetArtistsRelatedArtistsRequest getArtistsRelatedArtists(String id) {
        return new GetArtistsRelatedArtistsRequest(apiClient, id);
    }

    /**
     * <h4>Get Artist's Top Tracks</h4>
     * <p>Get Spotify catalog information about an artist's top tracks by country.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the artist.</p>
     * @return a {@link GetArtistsTopTracksRequest} object to build and execute the request
     */
    public GetArtistsTopTracksRequest getArtistsTopTracks(String id) {
        return new GetArtistsTopTracksRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Artists</h4>
     * <p>Get Spotify catalog information for several artists based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the artists. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleArtistsRequest} object to build and execute the request
     */
    public GetMultipleArtistsRequest getMultipleArtists(String ids) {
        return new GetMultipleArtistsRequest(apiClient, ids);
    }
}
