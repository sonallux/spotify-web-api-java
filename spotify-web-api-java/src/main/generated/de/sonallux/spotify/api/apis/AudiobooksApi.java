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
     * <p>Get Spotify catalog information for a single audiobook.<br><strong>Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.</strong></p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the audiobook.</p>
     * @return a {@link GetAudiobookRequest} object to build and execute the request
     */
    public GetAudiobookRequest getAudiobook(String id) {
        return new GetAudiobookRequest(apiClient, id);
    }

    /**
     * <h4>Get Audiobook Chapters</h4>
     * <p>Get Spotify catalog information about an audiobook's chapters.<br><strong>Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.</strong></p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify ID</a>for the audiobook.</p>
     * @return a {@link GetAudiobookChaptersRequest} object to build and execute the request
     */
    public GetAudiobookChaptersRequest getAudiobookChapters(String id) {
        return new GetAudiobookChaptersRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Audiobooks</h4>
     * <p>Get Spotify catalog information for several audiobooks identified by their Spotify IDs.<br><strong>Note: Audiobooks are only available for the US, UK, Ireland, New Zealand and Australia markets.</strong></p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify IDs</a>. For example: <code>ids=18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetMultipleAudiobooksRequest} object to build and execute the request
     */
    public GetMultipleAudiobooksRequest getMultipleAudiobooks(String ids) {
        return new GetMultipleAudiobooksRequest(apiClient, ids);
    }
}
