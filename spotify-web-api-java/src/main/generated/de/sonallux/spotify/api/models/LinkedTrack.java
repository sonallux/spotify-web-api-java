package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * LinkedTrackObject
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class LinkedTrack extends BaseObject {
    /**
     * <p>Known external URLs for this track.</p>
     */
    public ExternalUrl externalUrls;
}
