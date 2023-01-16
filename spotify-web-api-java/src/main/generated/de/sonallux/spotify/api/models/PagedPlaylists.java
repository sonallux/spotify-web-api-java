package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagedPlaylists
 */
@Getter
@Setter
@NoArgsConstructor
public class PagedPlaylists {
    public Paging<SimplifiedPlaylist> playlists;
}
