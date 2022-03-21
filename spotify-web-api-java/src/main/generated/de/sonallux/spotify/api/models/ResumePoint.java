package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ResumePointObject
 */
@Getter
@Setter
@NoArgsConstructor
public class ResumePoint {
    /**
     * <p>Whether or not the episode has been fully played by the user.</p>
     */
    public boolean fullyPlayed;
    /**
     * <p>The user's most recent position in the episode in milliseconds.</p>
     */
    public int resumePositionMs;
}
