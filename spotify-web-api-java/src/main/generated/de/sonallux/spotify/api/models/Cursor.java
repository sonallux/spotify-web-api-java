package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * CursorObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Cursor {
    /**
     * <p>The cursor to use as key to find the next page of items.</p>
     */
    public String after;
}
