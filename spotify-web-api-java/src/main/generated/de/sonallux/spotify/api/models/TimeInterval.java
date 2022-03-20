package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * TimeIntervalObject
 */
@Getter
@Setter
@NoArgsConstructor
public class TimeInterval {
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the interval.</p>
     */
    public float confidence;
    /**
     * <p>The duration (in seconds) of the time interval.</p>
     */
    public float duration;
    /**
     * <p>The starting point (in seconds) of the time interval.</p>
     */
    public float start;
}
