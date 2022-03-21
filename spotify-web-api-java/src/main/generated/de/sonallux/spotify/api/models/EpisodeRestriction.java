package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * EpisodeRestrictionObject
 */
@Getter
@Setter
@NoArgsConstructor
public class EpisodeRestriction {
    /**
     * <p>The reason for the restriction. Supported values:<br></p>
     * <ul>
     * <li><code>market</code> - The content item is not available in the given market.<br></li>
     * <li><code>product</code> - The content item is not available for the user's subscription type.<br></li>
     * <li><code>explicit</code> - The content item is explicit and the user's account is set to not play explicit content.<br>
     * Additional reasons may be added in the future.
     * <strong>Note</strong>: If you use this field, make sure that your application safely handles unknown values.</li>
     * </ul>
     */
    public String reason;
}
