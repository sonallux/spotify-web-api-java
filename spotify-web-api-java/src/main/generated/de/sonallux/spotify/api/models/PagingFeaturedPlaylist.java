package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagingFeaturedPlaylistObject
 */
@Getter
@Setter
@NoArgsConstructor
public class PagingFeaturedPlaylist {
    /**
     * <p>The localized message of a playlist.</p>
     */
    public String message;
    public Paging<SimplifiedPlaylist> playlists;
}
