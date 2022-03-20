package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagedAlbums
 */
@Getter
@Setter
@NoArgsConstructor
public class PagedAlbums {
    public Paging<SimplifiedAlbum> albums;
}
