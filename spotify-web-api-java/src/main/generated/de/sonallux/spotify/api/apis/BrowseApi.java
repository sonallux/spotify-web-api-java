package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.browse.*;
import lombok.RequiredArgsConstructor;

/**
 * Browse
 */
@RequiredArgsConstructor
public class BrowseApi {
    private final ApiClient apiClient;

    /**
     * <h4>Get Several Browse Categories</h4>
     * <p>Get a list of categories used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).</p>
     * @return a {@link GetCategoriesRequest} object to build and execute the request
     */
    public GetCategoriesRequest getCategories() {
        return new GetCategoriesRequest(apiClient);
    }

    /**
     * <h4>Get Category's Playlists</h4>
     * <p>Get a list of Spotify playlists tagged with a particular category.</p>
     * @param categoryId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify category ID</a> for the category.</p>
     * @return a {@link GetCategoriesPlaylistsRequest} object to build and execute the request
     */
    public GetCategoriesPlaylistsRequest getCategoriesPlaylists(String categoryId) {
        return new GetCategoriesPlaylistsRequest(apiClient, categoryId);
    }

    /**
     * <h4>Get Single Browse Category</h4>
     * <p>Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).</p>
     * @param categoryId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify category ID</a> for the category.</p>
     * @return a {@link GetCategoryRequest} object to build and execute the request
     */
    public GetCategoryRequest getCategory(String categoryId) {
        return new GetCategoryRequest(apiClient, categoryId);
    }

    /**
     * <h4>Get Featured Playlists</h4>
     * <p>Get a list of Spotify featured playlists (shown, for example, on a Spotify player's 'Browse' tab).</p>
     * @return a {@link GetFeaturedPlaylistsRequest} object to build and execute the request
     */
    public GetFeaturedPlaylistsRequest getFeaturedPlaylists() {
        return new GetFeaturedPlaylistsRequest(apiClient);
    }

    /**
     * <h4>Get New Releases</h4>
     * <p>Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).</p>
     * @return a {@link GetNewReleasesRequest} object to build and execute the request
     */
    public GetNewReleasesRequest getNewReleases() {
        return new GetNewReleasesRequest(apiClient);
    }

    /**
     * <h4>Get Available Genre Seeds</h4>
     * <p>Retrieve a list of available genres seed parameter values for <a href="https://developer.spotify.com/documentation/web-api/reference/get-recommendations">recommendations</a>.</p>
     * @return a {@link GetRecommendationGenresRequest} object to build and execute the request
     */
    public GetRecommendationGenresRequest getRecommendationGenres() {
        return new GetRecommendationGenresRequest(apiClient);
    }

    /**
     * <h4>Get Recommendations</h4>
     * <p>Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks. If there is sufficient information about the provided seeds, a list of tracks will be returned together with pool size details.</p><p>For artists and tracks that are very new or obscure there might not be enough data to generate a list of tracks.</p>
     * @return a {@link GetRecommendationsRequest} object to build and execute the request
     */
    public GetRecommendationsRequest getRecommendations() {
        return new GetRecommendationsRequest(apiClient);
    }
}
