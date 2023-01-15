package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PagedPlaylistsAndMessage
 */
@Getter
@Setter
@NoArgsConstructor
public class PagedPlaylistsAndMessage {
    /**
     * <p>A description of the playlists</p>
     */
    public String message;
    public Paging playlists;
}
