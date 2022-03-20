package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.episodes.*;
import lombok.RequiredArgsConstructor;

/**
 * Episodes
 */
@RequiredArgsConstructor
public class EpisodesApi {
    private final ApiClient apiClient;

    /**
     * <h3>Get Episode</h3>
     * <p>Get Spotify catalog information for a single episode identified by its unique Spotify ID.</p>
     * @param id <p>The <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> for the episode.</p>
     * @return a {@link GetEpisodeRequest} object to build and execute the request
     */
    public GetEpisodeRequest getEpisode(String id) {
        return new GetEpisodeRequest(apiClient, id);
    }

    /**
     * <h3>Get Several Episodes</h3>
     * <p>Get Spotify catalog information for several episodes based on their Spotify IDs.</p>
     * @param ids <p>A comma-separated list of the <a href="/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a> for the episodes. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleEpisodesRequest} object to build and execute the request
     */
    public GetMultipleEpisodesRequest getMultipleEpisodes(String ids) {
        return new GetMultipleEpisodesRequest(apiClient, ids);
    }
}
