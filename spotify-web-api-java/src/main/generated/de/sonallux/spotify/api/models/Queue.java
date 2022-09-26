package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * QueueObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Queue {
    /**
     * <p>The currently playing track or episode. Can be <code>null</code>.</p>
     */
    public BaseObject currentlyPlaying;
    /**
     * <p>The tracks or episodes in the queue. Can be empty.</p>
     */
    public java.util.List<BaseObject> queue;
}
