package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.episodes.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;

/**
 * Episodes
 */
@NullMarked
@RequiredArgsConstructor
public class EpisodesApi {
    private final ApiClient apiClient;

    /**
     * <h4>Check User's Saved Episodes</h4>
     * <p>Check if one or more episodes is already saved in the current Spotify user's 'Your Episodes' library.<br/>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>..</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     * @return a {@link CheckUsersSavedEpisodesRequest} object to build and execute the request
     */
    public CheckUsersSavedEpisodesRequest checkUsersSavedEpisodes(String ids) {
        return new CheckUsersSavedEpisodesRequest(apiClient, ids);
    }

    /**
     * <h4>Get Episode</h4>
     * <p>Get Spotify catalog information for a single episode identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a> for the episode.</p>
     * @return a {@link GetEpisodeRequest} object to build and execute the request
     */
    public GetEpisodeRequest getEpisode(String id) {
        return new GetEpisodeRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Episodes</h4>
     * <p>Get Spotify catalog information for several episodes based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleEpisodesRequest} object to build and execute the request
     */
    public GetMultipleEpisodesRequest getMultipleEpisodes(String ids) {
        return new GetMultipleEpisodesRequest(apiClient, ids);
    }

    /**
     * <h4>Get User's Saved Episodes</h4>
     * <p>Get a list of the episodes saved in the current Spotify user's library.<br/>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @return a {@link GetUsersSavedEpisodesRequest} object to build and execute the request
     */
    public GetUsersSavedEpisodesRequest getUsersSavedEpisodes() {
        return new GetUsersSavedEpisodesRequest(apiClient);
    }

    /**
     * <h4>Remove User's Saved Episodes</h4>
     * <p>Remove one or more episodes from the current user's library.<br/>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. <br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link RemoveEpisodesUserRequest} object to build and execute the request
     */
    public RemoveEpisodesUserRequest removeEpisodesUser(java.util.List<String> ids) {
        return new RemoveEpisodesUserRequest(apiClient, ids);
    }

    /**
     * <h4>Save Episodes for Current User</h4>
     * <p>Save one or more episodes to the current user's library.<br/>This API endpoint is in <strong>beta</strong> and could change without warning. Please share any feedback that you have, or issues that you discover, in our <a href="https://community.spotify.com/t5/Spotify-for-Developers/bd-p/Spotify_Developer">developer community forum</a>.</p>
     * @param ids <p>A JSON array of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. <br/>A maximum of 50 items can be specified in one request. <em><strong>Note</strong>: if the <code>ids</code> parameter is present in the query string, any IDs listed here in the body will be ignored.</em></p>
     * @return a {@link SaveEpisodesUserRequest} object to build and execute the request
     */
    public SaveEpisodesUserRequest saveEpisodesUser(java.util.List<String> ids) {
        return new SaveEpisodesUserRequest(apiClient, ids);
    }
}
