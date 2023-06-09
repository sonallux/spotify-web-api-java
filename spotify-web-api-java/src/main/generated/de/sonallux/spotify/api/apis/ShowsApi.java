package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.shows.*;
import lombok.RequiredArgsConstructor;

/**
 * Shows
 */
@RequiredArgsConstructor
public class ShowsApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Shows</h4>
     * <p>Check if one or more shows is already saved in the current Spotify user's library.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the shows. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedShowsRequest} object to build and execute the request
     */
    public CheckUsersSavedShowsRequest checkUsersSavedShows(String ids) {
        return new CheckUsersSavedShowsRequest(apiClient, ids);
    }

    /**
     * <h4>Get Several Shows</h4>
     * <p>Get Spotify catalog information for several shows based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the shows. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleShowsRequest} object to build and execute the request
     */
    public GetMultipleShowsRequest getMultipleShows(String ids) {
        return new GetMultipleShowsRequest(apiClient, ids);
    }

    /**
     * <h4>Get Show</h4>
     * <p>Get Spotify catalog information for a single show identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the show.</p>
     * @return a {@link GetShowRequest} object to build and execute the request
     */
    public GetShowRequest getShow(String id) {
        return new GetShowRequest(apiClient, id);
    }

    /**
     * <h4>Get Show Episodes</h4>
     * <p>Get Spotify catalog information about an show’s episodes. Optional parameters can be used to limit the number of episodes returned.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the show.</p>
     * @return a {@link GetShowsEpisodesRequest} object to build and execute the request
     */
    public GetShowsEpisodesRequest getShowsEpisodes(String id) {
        return new GetShowsEpisodesRequest(apiClient, id);
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
     * <h4>Remove User's Saved Shows</h4>
     * <p>Delete one or more shows from current Spotify user's library.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>.<br>A maximum of 50 items can be specified in one request. <em>Note: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveShowsUserRequest} object to build and execute the request
     */
    public RemoveShowsUserRequest removeShowsUser(java.util.List<String> ids) {
        return new RemoveShowsUserRequest(apiClient, ids);
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
}
