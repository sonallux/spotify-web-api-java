package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagingFeaturedPlaylistObject
 */
@Getter
@Setter
@NoArgsConstructor
public class PagingFeaturedPlaylist {
    public String message;
    public Paging<SimplifiedPlaylist> playlists;
}
