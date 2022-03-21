package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * SimplifiedArtistObject
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class SimplifiedArtist extends BaseObject {
    /**
     * <p>Known external URLs for this artist.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>The name of the artist.</p>
     */
    public String name;
}
