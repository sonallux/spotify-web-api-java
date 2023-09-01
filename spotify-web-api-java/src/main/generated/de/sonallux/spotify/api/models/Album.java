package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * AlbumObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Album extends AlbumBase {
    /**
     * <p>The artists of the album. Each artist object includes a link in <code>href</code> to more detailed information about the artist.</p>
     */
    public java.util.List<SimplifiedArtist> artists;
    /**
     * <p>The copyright statements of the album.</p>
     */
    public java.util.List<Copyright> copyrights;
    /**
     * <p>Known external IDs for the album.</p>
     */
    public ExternalId externalIds;
    /**
     * <p>A list of the genres the album is associated with. If not yet classified, the array is empty.</p>
     */
    public java.util.List<String> genres;
    /**
     * <p>The label associated with the album.</p>
     */
    public String label;
    /**
     * <p>The popularity of the album. The value will be between 0 and 100, with 100 being the most popular.</p>
     */
    public int popularity;
    /**
     * <p>The tracks of the album.</p>
     */
    public Paging<SimplifiedTrack> tracks;
}
