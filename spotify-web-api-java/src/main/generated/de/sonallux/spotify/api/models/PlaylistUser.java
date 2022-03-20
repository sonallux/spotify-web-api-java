package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * PlaylistUserObject
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class PlaylistUser extends BaseObject {
    /**
     * <p>Known public external URLs for this user.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>Information about the followers of this user.</p>
     */
    public Followers followers;
}
