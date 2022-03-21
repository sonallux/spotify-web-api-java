package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * CursorPagedArtists
 */
@Getter
@Setter
@NoArgsConstructor
public class CursorPagedArtists {
    public CursorPaging<Artist> artists;
}
