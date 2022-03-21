package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * EpisodeObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Episode extends EpisodeBase {
    /**
     * <p>The show on which the episode belongs.</p>
     */
    public SimplifiedShow show;
}
