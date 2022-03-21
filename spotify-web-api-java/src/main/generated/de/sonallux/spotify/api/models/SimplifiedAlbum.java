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
     * <p>The field is present when getting an artist's albums. Compare to album_type this field represents relationship between the artist and the album.</p>
     */
    public String albumGroup;
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<SimplifiedArtist> artists;
}
