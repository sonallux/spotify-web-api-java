package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.chapters.*;
import lombok.RequiredArgsConstructor;

/**
 * Chapters
 */
@RequiredArgsConstructor
public class ChaptersApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get a Chapter</h4>
     * <p>Get Spotify catalog information for a single chapter.<br><strong>Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.</strong></p>
     * @param id <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a>for the chapter.</p>
     * @return a {@link GetChapterRequest} object to build and execute the request
     */
    public GetChapterRequest getChapter(String id) {
        return new GetChapterRequest(apiClient, id);
    }

    /**
     * <h4>Get Several Chapters</h4>
     * <p>Get Spotify catalog information for several chapters identified by their Spotify IDs.<br><strong>Note: Chapters are only available for the US, UK, Ireland, New Zealand and Australia markets.</strong></p>
     * @param ids <p>A comma-separated list of the <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify IDs</a>. For example: <code>ids=4iV5W9uYEdYUVa79Axb7Rh,1301WleyT98MSxVHPZCA6M</code>. Maximum: 50 IDs.</p>
     * @return a {@link GetSeveralChaptersRequest} object to build and execute the request
     */
    public GetSeveralChaptersRequest getSeveralChapters(String ids) {
        return new GetSeveralChaptersRequest(apiClient, ids);
    }
}
