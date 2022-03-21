package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagedCategories
 */
@Getter
@Setter
@NoArgsConstructor
public class PagedCategories {
    public Paging<Category> categories;
}
