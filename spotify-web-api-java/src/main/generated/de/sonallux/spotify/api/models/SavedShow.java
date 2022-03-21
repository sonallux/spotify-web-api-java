package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SavedShowObject
 */
@Getter
@Setter
@NoArgsConstructor
public class SavedShow {
    /**
     * <p>The date and time the show was saved.
     * Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.
     * If the time is imprecise (for example, the date/time of an album release), an additional field indicates the precision; see for example, release_date in an album object.</p>
     */
    public java.time.Instant addedAt;
    /**
     * <p>Information about the show.</p>
     */
    public SimplifiedShow show;
}
