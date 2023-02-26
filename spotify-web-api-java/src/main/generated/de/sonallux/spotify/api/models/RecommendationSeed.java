package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * RecommendationSeedObject
 */
@Getter
@Setter
@NoArgsConstructor
public class RecommendationSeed {
    /**
     * <p>The number of tracks available after min_* and max_* filters have been applied.</p>
     */
    public int afterfilteringsize;
    /**
     * <p>The number of tracks available after relinking for regional availability.</p>
     */
    public int afterrelinkingsize;
    /**
     * <p>A link to the full track or artist data for this seed. For tracks this will be a link to a Track Object. For artists a link to an Artist Object. For genre seeds, this value will be <code>null</code>.</p>
     */
    public String href;
    /**
     * <p>The id used to select this seed. This will be the same as the string used in the <code>seed_artists</code>, <code>seed_tracks</code> or <code>seed_genres</code> parameter.</p>
     */
    public String id;
    /**
     * <p>The number of recommended tracks available for this seed.</p>
     */
    public int initialpoolsize;
    /**
     * <p>The entity type of this seed. One of <code>artist</code>, <code>track</code> or <code>genre</code>.</p>
     */
    public String type;
}
