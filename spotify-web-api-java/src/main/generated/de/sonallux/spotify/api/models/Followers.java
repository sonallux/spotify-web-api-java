package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * FollowersObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Followers {
    /**
     * <p>This will always be set to null, as the Web API does not support it at the moment.</p>
     */
    public String href;
    /**
     * <p>The total number of followers.</p>
     */
    public int total;
}
