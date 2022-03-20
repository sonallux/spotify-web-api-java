package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ExplicitContentSettingsObject
 */
@Getter
@Setter
@NoArgsConstructor
public class ExplicitContentSettings {
    /**
     * <p>When <code>true</code>, indicates that explicit content should not be played.</p>
     */
    public boolean filterEnabled;
    /**
     * <p>When <code>true</code>, indicates that the explicit content setting is locked and can't be changed by the user.</p>
     */
    public boolean filterLocked;
}
