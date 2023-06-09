package de.sonallux.spotify.api.apis;

import de.sonallux.spotify.api.http.ApiClient;
import de.sonallux.spotify.api.apis.categories.*;
import lombok.RequiredArgsConstructor;

/**
 * Categories
 */
@RequiredArgsConstructor
public class CategoriesApi {
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
     * <h4>Get Single Browse Category</h4>
     * <p>Get a single category used to tag items in Spotify (on, for example, the Spotify player’s “Browse” tab).</p>
     * @param categoryId <p>The <a href="https://developer.spotify.com/documentation/web-api/concepts/spotify-uris-ids">Spotify category ID</a> for the category.</p>
     * @return a {@link GetCategoryRequest} object to build and execute the request
     */
    public GetCategoryRequest getCategory(String categoryId) {
        return new GetCategoryRequest(apiClient, categoryId);
    }
}
