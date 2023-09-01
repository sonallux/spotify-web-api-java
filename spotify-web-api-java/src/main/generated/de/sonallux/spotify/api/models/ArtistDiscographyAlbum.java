package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ArtistDiscographyAlbumObject
 */
@Getter
@Setter
@NoArgsConstructor
public class ArtistDiscographyAlbum extends SimplifiedAlbum {
    /**
     * <p>This field describes the relationship between the artist and the album.</p>
     */
    public String albumGroup;
}
