package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.audiobooks.*;
import lombok.RequiredArgsConstructor;

/**
 * Audiobooks
 */
@RequiredArgsConstructor
public class AudiobooksApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get an Audiobook</h4>
     * <p>Get Spotify catalog information for a single audiobook.<br><strong>Note: Audiobooks are only available for the US market.</strong></p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a>for the audiobook.</p>
     * @return a {@link GetAudiobookRequest} object to build and execute the request
     */
    public GetAudiobookRequest getAudiobook(String id) {
        return new GetAudiobookRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Audiobooks</h4>
     * <p>Get Spotify catalog information for several audiobooks identified by their Spotify IDs.<br><strong>Note: Audiobooks are only available for the US market.</strong></p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleAudiobooksRequest} object to build and execute the request
     */
    public GetMultipleAudiobooksRequest getMultipleAudiobooks(String ids) {
        return new GetMultipleAudiobooksRequest(apiClient, ids);
    }
}
