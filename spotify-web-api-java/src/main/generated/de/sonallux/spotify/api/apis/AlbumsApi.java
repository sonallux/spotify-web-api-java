package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.albums.*;
import lombok.RequiredArgsConstructor;

/**
 * Albums
 */
@RequiredArgsConstructor
public class AlbumsApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Albums</h4>
     * <p>Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the albums. Maximum: 20 IDs.</p>
     * @return a {@link CheckUsersSavedAlbumsRequest} object to build and execute the request
     */
    public CheckUsersSavedAlbumsRequest checkUsersSavedAlbums(String ids) {
        return new CheckUsersSavedAlbumsRequest(apiClient, ids);
    }

    /**
     * <h4>Get Album</h4>
     * <p>Get Spotify catalog information for a single album.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the album.</p>
     * @return a {@link GetAlbumRequest} object to build and execute the request
     */
    public GetAlbumRequest getAlbum(String id) {
        return new GetAlbumRequest(apiClient, id);
    }

    /**
     * <h4>Get Album Tracks</h4>
     * <p>Get Spotify catalog information about an album’s tracks. Optional parameters can be used to limit the number of tracks returned.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> of the album.</p>
     * @return a {@link GetAlbumsTracksRequest} object to build and execute the request
     */
    public GetAlbumsTracksRequest getAlbumsTracks(String id) {
        return new GetAlbumsTracksRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Albums</h4>
     * <p>Get Spotify catalog information for multiple albums identified by their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the albums. Maximum: 20 IDs.</p>
     * @return a {@link GetMultipleAlbumsRequest} object to build and execute the request
     */
    public GetMultipleAlbumsRequest getMultipleAlbums(String ids) {
        return new GetMultipleAlbumsRequest(apiClient, ids);
    }

    /**
     * <h4>Get New Releases</h4>
     * <p>Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).</p>
     * @return a {@link GetNewReleasesRequest} object to build and execute the request
     */
    public GetNewReleasesRequest getNewReleases() {
        return new GetNewReleasesRequest(apiClient);
    }

    /**
     * <h4>Get User's Saved Albums</h4>
     * <p>Get a list of the albums saved in the current Spotify user's 'Your Music' library.</p>
     * @return a {@link GetUsersSavedAlbumsRequest} object to build and execute the request
     */
    public GetUsersSavedAlbumsRequest getUsersSavedAlbums() {
        return new GetUsersSavedAlbumsRequest(apiClient);
    }

    /**
     * <h4>Remove Users' Saved Albums</h4>
     * <p>Remove one or more albums from the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveAlbumsUserRequest} object to build and execute the request
     */
    public RemoveAlbumsUserRequest removeAlbumsUser(java.util.List<String> ids) {
        return new RemoveAlbumsUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Albums for Current User</h4>
     * <p>Save one or more albums to the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveAlbumsUserRequest} object to build and execute the request
     */
    public SaveAlbumsUserRequest saveAlbumsUser(java.util.List<String> ids) {
        return new SaveAlbumsUserRequest(apiClient, ids);
    }
}
