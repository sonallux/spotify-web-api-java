package de.sonallux.spotify.api.apis.playlists;

import com.fasterxml.jackson.core.type.TypeReference;
import de.sonallux.spotify.api.http.ApiCall;
import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.http.Request;
import de.sonallux.spotify.api.models.*;

/**
 * <h2>Get Playlist Items request</h2>
 *
 * <h3>Required OAuth scopes</h3>
 * <code>playlist-read-public, playlist-read-private</code>
 *
 * <h3>Response</h3>
 * <p>Pages of playlist tracks</p>
 */
public class GetPlaylistsTracksRequest {
    private static final TypeReference<Paging<PlaylistTrack>> RESPONSE_TYPE = new TypeReference<>() {};
    private final ApiClient apiClient;
    private final Request request;

    /**
     * Get Playlist Items request
     * @param apiClient <p>The API client</p>
     * @param playlistId <p>The <a href="https://developer.spotify.com/documentation/web-api/#spotify-uris-and-ids">Spotify ID</a> of the playlist.</p>
     */
    public GetPlaylistsTracksRequest(ApiClient apiClient, String playlistId) {
        this.apiClient = apiClient;
        this.request = new Request("GET", "/playlists/{playlist_id}/tracks")
            .addPathParameter("playlist_id", String.valueOf(playlistId))
        ;
        this.additionalTypes("track,episode");
    }

    /**
     * @param market <p>An <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2 country code</a>. If a country code is specified, only content that is available in that market will be returned.<br>If a valid user access token is specified in the request header, the country associated with the user account will take priority over this parameter.<br><em><strong>Note</strong>: If neither market or user country are provided, the content is considered unavailable for the client.</em><br>Users can view the country that is associated with their account in the <a href="https://www.spotify.com/se/account/overview/">account settings</a>.</p>
     * @return this request
     */
    public GetPlaylistsTracksRequest market(String market) {
        this.request.addQueryParameter("market", String.valueOf(market));
        return this;
    }

    /**
     * @param fields <p>Filters for the query: a comma-separated list of the fields to return. If omitted, all fields are returned. For example, to get just the total number of items and the request limit:<br><code>fields=total,limit</code><br>A dot separator can be used to specify non-reoccurring fields, while parentheses can be used to specify reoccurring fields within objects. For example, to get just the added date and user ID of the adder:<br><code>fields=items(added_at,added_by.id)</code><br>Use multiple parentheses to drill down into nested objects, for example:<br><code>fields=items(track(name,href,album(name,href)))</code><br>Fields can be excluded by prefixing them with an exclamation mark, for example:<br><code>fields=items.track.album(!external_urls,images)</code></p>
     * @return this request
     */
    public GetPlaylistsTracksRequest fields(String fields) {
        this.request.addQueryParameter("fields", String.valueOf(fields));
        return this;
    }

    /**
     * @param limit <p>The maximum number of items to return. Default: 20. Minimum: 1. Maximum: 100.</p>
     * @return this request
     */
    public GetPlaylistsTracksRequest limit(int limit) {
        this.request.addQueryParameter("limit", String.valueOf(limit));
        return this;
    }

    /**
     * @param offset <p>The index of the first item to return. Default: 0 (the first item). Use with limit to get the next set of items.</p>
     * @return this request
     */
    public GetPlaylistsTracksRequest offset(int offset) {
        this.request.addQueryParameter("offset", String.valueOf(offset));
        return this;
    }

    /**
     * @param additionalTypes <p>A comma-separated list of item types that your client supports besides the default <code>track</code> type. Valid types are: <code>track</code> and <code>episode</code>.<br><em><strong>Note</strong>: This parameter was introduced to allow existing clients to maintain their current behaviour and might be deprecated in the future.</em><br>In addition to providing this parameter, make sure that your client properly handles cases of new types in the future by checking against the <code>type</code> field of each object.</p>
     * @return this request
     */
    public GetPlaylistsTracksRequest additionalTypes(String additionalTypes) {
        this.request.addQueryParameter("additional_types", String.valueOf(additionalTypes));
        return this;
    }

    /**
     * Build the request into an executable api call
     * @return an executable api call
     */
    public ApiCall<Paging<PlaylistTrack>> build() {
        return apiClient.createApiCall(request, RESPONSE_TYPE);
    }
}
