package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PlaylistOwnerObject
 */
@Getter
@Setter
@NoArgsConstructor
public class PlaylistOwner extends PlaylistUser {
    /**
     * <p>The name displayed on the user's profile. <code>null</code> if not available.</p>
     */
    public String displayName;
}
