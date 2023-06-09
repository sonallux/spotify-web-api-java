package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * PlaylistTrackObject
 */
@Getter
@Setter
@NoArgsConstructor
public class PlaylistTrack {
    /**
     * <p>The date and time the track or episode was added. <em><strong>Note</strong>: some very old playlists may return <code>null</code> in this field.</em></p>
     */
    public java.time.Instant addedAt;
    /**
     * <p>The Spotify user who added the track or episode. <em><strong>Note</strong>: some very old playlists may return <code>null</code> in this field.</em></p>
     */
    public PlaylistUser addedBy;
    /**
     * <p>Whether this track or episode is a <a href="https://developer.spotify.com/documentation/web-api/concepts/playlists/#local-files">local file</a> or not.</p>
     */
    public boolean isLocal;
    /**
     * <p>Information about the track or episode.</p>
     */
    public BaseObject track;
}
