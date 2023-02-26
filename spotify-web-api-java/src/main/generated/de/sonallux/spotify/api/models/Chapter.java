package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * ChapterObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Chapter extends ChapterBase {
    /**
     * <p>The audiobook for which the chapter belongs.</p>
     */
    public SimplifiedAudiobook audiobook;
}
