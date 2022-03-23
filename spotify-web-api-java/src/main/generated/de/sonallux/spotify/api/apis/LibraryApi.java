package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.library.*;
import lombok.RequiredArgsConstructor;

/**
 * Library
 */
@RequiredArgsConstructor
public class LibraryApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check Saved Albums</h4>
     * <p>Check if one or more albums is already saved in the current Spotify user's 'Your Music' library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the albums. Maximum: 20 IDs.</p>
     * @return a {@link CheckUsersSavedAlbumsRequest} object to build and execute the request
     */
    public CheckUsersSavedAlbumsRequest checkUsersSavedAlbums(String ids) {
        return new CheckUsersSavedAlbumsRequest(apiClient, ids);
    }

    /**
     * <h4>Check User's Saved Episodes</h4>
     * <p>Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.<br>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>..</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedEpisodesRequest} object to build and execute the request
     */
    public CheckUsersSavedEpisodesRequest checkUsersSavedEpisodes(String ids) {
        return new CheckUsersSavedEpisodesRequest(apiClient, ids);
    }

    /**
     * <h4>Check User's Saved Shows</h4>
     * <p>Check if one or more shows is already saved in the current Spotify user's library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the shows. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedShowsRequest} object to build and execute the request
     */
    public CheckUsersSavedShowsRequest checkUsersSavedShows(String ids) {
        return new CheckUsersSavedShowsRequest(apiClient, ids);
    }

    /**
     * <h4>Check User's Saved Tracks</h4>
     * <p>Check if one or more tracks is already saved in the current Spotify user's 'Your Music' library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedTracksRequest} object to build and execute the request
     */
    public CheckUsersSavedTracksRequest checkUsersSavedTracks(String ids) {
        return new CheckUsersSavedTracksRequest(apiClient, ids);
    }

    /**
     * <h4>Get Saved Albums</h4>
     * <p>Get a list of the albums saved in the current Spotify user's 'Your Music' library.</p>
     * @return a {@link GetUsersSavedAlbumsRequest} object to build and execute the request
     */
    public GetUsersSavedAlbumsRequest getUsersSavedAlbums() {
        return new GetUsersSavedAlbumsRequest(apiClient);
    }

    /**
     * <h4>Get User's Saved Episodes</h4>
     * <p>Get a list of the episodes saved in the current Spotify user's library.<br>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @return a {@link GetUsersSavedEpisodesRequest} object to build and execute the request
     */
    public GetUsersSavedEpisodesRequest getUsersSavedEpisodes() {
        return new GetUsersSavedEpisodesRequest(apiClient);
    }

    /**
     * <h4>Get User's Saved Shows</h4>
     * <p>Get a list of shows saved in the current Spotify user's library. Optional parameters can be used to limit the number of shows returned.</p>
     * @return a {@link GetUsersSavedShowsRequest} object to build and execute the request
     */
    public GetUsersSavedShowsRequest getUsersSavedShows() {
        return new GetUsersSavedShowsRequest(apiClient);
    }

    /**
     * <h4>Get User's Saved Tracks</h4>
     * <p>Get a list of the songs saved in the current Spotify user's 'Your Music' library.</p>
     * @return a {@link GetUsersSavedTracksRequest} object to build and execute the request
     */
    public GetUsersSavedTracksRequest getUsersSavedTracks() {
        return new GetUsersSavedTracksRequest(apiClient);
    }

    /**
     * <h4>Remove Albums</h4>
     * <p>Remove one or more albums from the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveAlbumsUserRequest} object to build and execute the request
     */
    public RemoveAlbumsUserRequest removeAlbumsUser(java.util.List<String> ids) {
        return new RemoveAlbumsUserRequest(apiClient, ids);
    }

    /**
     * <h4>Remove User's Saved Episodes</h4>
     * <p>Remove one or more episodes from the current user's library.<br>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. <br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveEpisodesUserRequest} object to build and execute the request
     */
    public RemoveEpisodesUserRequest removeEpisodesUser(java.util.List<String> ids) {
        return new RemoveEpisodesUserRequest(apiClient, ids);
    }

    /**
     * <h4>Remove User's Saved Shows</h4>
     * <p>Delete one or more shows from current Spotify user's library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>.<br>A maximum of 50 items can be specified in one request. <em>Note: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveShowsUserRequest} object to build and execute the request
     */
    public RemoveShowsUserRequest removeShowsUser(java.util.List<String> ids) {
        return new RemoveShowsUserRequest(apiClient, ids);
    }

    /**
     * <h4>Remove Tracks for Current User</h4>
     * <p>Remove one or more tracks from the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveTracksUserRequest} object to build and execute the request
     */
    public RemoveTracksUserRequest removeTracksUser(java.util.List<String> ids) {
        return new RemoveTracksUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Albums</h4>
     * <p>Save one or more albums to the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveAlbumsUserRequest} object to build and execute the request
     */
    public SaveAlbumsUserRequest saveAlbumsUser(java.util.List<String> ids) {
        return new SaveAlbumsUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Episodes for User</h4>
     * <p>Save one or more episodes to the current user's library.<br>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. <br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveEpisodesUserRequest} object to build and execute the request
     */
    public SaveEpisodesUserRequest saveEpisodesUser(java.util.List<String> ids) {
        return new SaveEpisodesUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Shows for Current User</h4>
     * <p>Save one or more shows to current Spotify user's library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>.<br>A maximum of 50 items can be specified in one request. <em>Note: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveShowsUserRequest} object to build and execute the request
     */
    public SaveShowsUserRequest saveShowsUser(java.util.List<String> ids) {
        return new SaveShowsUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Tracks for Current User</h4>
     * <p>Save one or more tracks to the current user's 'Your Music' library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>[&quot;4iV5W9uYEdYUVa79Axb7Rh&quot;, &quot;1301WleyT98MSxVHPZCA6M&quot;]</code><br>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveTracksUserRequest} object to build and execute the request
     */
    public SaveTracksUserRequest saveTracksUser(java.util.List<String> ids) {
        return new SaveTracksUserRequest(apiClient, ids);
    }
}
