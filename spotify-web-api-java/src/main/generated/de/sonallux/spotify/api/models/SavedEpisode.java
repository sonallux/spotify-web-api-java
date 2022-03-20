package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SavedEpisodeObject
 */
@Getter
@Setter
@NoArgsConstructor
public class SavedEpisode {
    /**
     * <p>The date and time the episode was saved.
     * Timestamps are returned in ISO 8601 format as Coordinated Universal Time (UTC) with a zero offset: YYYY-MM-DDTHH:MM:SSZ.</p>
     */
    public java.time.Instant addedAt;
    /**
     * <p>Information about the episode.</p>
     */
    public Episode episode;
}
