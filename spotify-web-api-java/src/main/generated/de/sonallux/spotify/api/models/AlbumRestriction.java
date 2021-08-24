package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/#object-albumrestrictionobject">AlbumRestrictionObject</a>
 */
@Getter
@Setter
@NoArgsConstructor
public class AlbumRestriction {
    /**
     * <p>The reason for the restriction. Albums may be restricted if the content is not available in a given market, to the user's subscription type, or when the user's account is set to not play explicit content. Additional reasons may be added in the future.</p>
     */
    public String reason;
}
