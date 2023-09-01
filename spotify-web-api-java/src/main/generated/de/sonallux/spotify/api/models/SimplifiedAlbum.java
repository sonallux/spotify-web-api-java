package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SimplifiedAlbumObject
 */
@Getter
@Setter
@NoArgsConstructor
public class SimplifiedAlbum extends AlbumBase {
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<SimplifiedArtist> artists;
}
