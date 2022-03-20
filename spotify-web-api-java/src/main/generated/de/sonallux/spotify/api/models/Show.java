package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ShowObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Show extends ShowBase {
    /**
     * <p>The episodes of the show.</p>
     */
    public Paging<SimplifiedEpisode> episodes;
}
