package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SavedAlbumObject
 */
@Getter
@Setter
@NoArgsConstructor
public class SavedAlbum {
    /**
     * <p>The date and time the album was saved
     * Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.
     * If the time is imprecise (for example, the date/time of an album release), an additional field indicates the precision; see for example, release_date in an album object.</p>
     */
    public java.time.Instant addedAt;
    /**
     * <p>Information about the album.</p>
     */
    public Album album;
}
