package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.search.*;
import lombok.RequiredArgsConstructor;

/**
 * Search
 */
@RequiredArgsConstructor
public class SearchApi {
    private final ApiClient apiClient;

    /**
     * <h4>Search for Item</h4>
     * <p>Get Spotify catalog information about albums, artists, playlists, tracks, shows or episodes that match a keyword string.</p>
     * @param q <p>Your search query.</p><p>You can narrow down your search using field filters. The available filters are <code>album</code>, <code>artist</code>, <code>track</code>, <code>year</code>, <code>upc</code>, <code>tag:hipster</code>, <code>tag:new</code>, <code>isrc</code>, and <code>genre</code>. Each field filter only applies to certain result types.</p><p>The <code>artist</code> and <code>year</code> filters can be used while searching albums, artists and tracks. You can filter on a single <code>year</code> or a range (e.g. 1955-1960).<br>The <code>album</code> filter can be used while searching albums and tracks.<br>The <code>genre</code> filter can be used while searching artists and tracks.<br>The <code>isrc</code> and <code>track</code> filters can be used while searching tracks.<br>The <code>upc</code>, <code>tag:new</code> and <code>tag:hipster</code> filters can only be used while searching albums. The <code>tag:new</code> filter will return albums released in the past two weeks and <code>tag:hipster</code> can be used to return only albums with the lowest 10% popularity.<br></p>
     * @param type <p>A comma-separated list of item types to search across. Search results include hits from all the specified item types. For example: <code>q=abacab&amp;type=album,track</code> returns both albums and tracks matching &quot;abacab&quot;.</p>
     * @return a {@link SearchRequest} object to build and execute the request
     */
    public SearchRequest search(String q, java.util.List<String> type) {
        return new SearchRequest(apiClient, q, type);
    }
}
