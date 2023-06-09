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
}
