package de.sonallux.spotify.api.apis.search;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * Search for Item request
 *
 * <h3>Response</h3>
 * <p>Search response</p>
 */
public class SearchRequest {
    private static final TypeReference<SearchItems> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * <h3>Search for Item request</h3>
     * @param apiClient <p>The API client</p>
     * @param q <p>Your search query.</p><p>You can narrow down your search using field filters. The available filters are <code>album</code>, <code>artist</code>, <code>track</code>, <code>year</code>, <code>upc</code>, <code>tag:hipster</code>, <code>tag:new</code>, <code>isrc</code>, and <code>genre</code>. Each field filter only applies to certain result types.</p><p>The <code>artist</code> filter can be used while searching albums, artists or tracks.<br>The <code>album</code> and <code>year</code> filters can be used while searching albums or tracks. You can filter on a single <code>year</code> or a range (e.g. 1955-1960).<br>The <code>genre</code> filter can be use while searching tracks and artists.<br>The <code>isrc</code> and <code>track</code> filters can be used while searching tracks.<br>The <code>upc</code>, <code>tag:new</code> and <code>tag:hipster</code> filters can only be used while searching albums. The <code>tag:new</code> filter will return albums released in the past two weeks and <code>tag:hipster</code> can be used to return only albums with the lowest 10% popularity.<br></p><p>You can also use the <code>NOT</code> operator to exclude keywords from your search.</p>
     * @param type <p>A comma-separated list of item types to search across. Search results include hits from all the specified item types. For example: <code>q=name:abacab&amp;type=album,track</code> returns both albums and tracks with &quot;abacab&quot; included in their name.</p>
     */
    public SearchRequest(ApiClient apiClient, String q, java.util.List<String> type) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/search")
            .addQueryParameter("q", String.valueOf(q))
            .addQueryParameter("type", String.valueOf(type))
        ;
    }

    /**
     * <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     */
    public SearchRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * <p>The maximum number of results to return in each item type.</p>
     */
    public SearchRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * <p>The index of the first result to return. Use with limit to get the next page of search results.</p>
     */
    public SearchRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * <p>If <code>include_external=audio</code> is specified it signals that the client can play externally hosted audio content, and marks the content as playable in the response. By default externally hosted audio content is marked as unplayable in the response.</p>
     */
    public SearchRequest includeExternal(String includeExternal) {
        this.request.addQueryParameter("include_external", String.valueOf(includeExternal));
        return this;
    }

    /**
     * Build the request into an executable call
     */
    public ApiCall<SearchItems> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
