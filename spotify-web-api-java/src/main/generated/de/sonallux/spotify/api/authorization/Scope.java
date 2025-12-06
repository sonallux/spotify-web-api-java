package de.sonallux.spotify.api.authorization;

import org.jspecify.annotations.NullMarked;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/concepts/scopes">Authorization Scopes</a>
 */
@NullMarked
public enum Scope {
    /**
     * Communicate with the Spotify app on your device.
     */
    APP_REMOTE_CONTROL("app-remote-control"),
    /**
     * Manage your private playlists.
     */
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private"),
    /**
     * Manage your public playlists.
     */
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public"),
    /**
     * Access your collaborative playlists.
     */
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),
    /**
     * Access your private playlists.
     */
    PLAYLIST_READ_PRIVATE("playlist-read-private"),
    /**
     * Play content and control playback on your other devices.
     */
    STREAMING("streaming"),
    /**
     * Upload images to Spotify on your behalf.
     */
    UGC_IMAGE_UPLOAD("ugc-image-upload"),
    /**
     * Manage your saved content.
     */
    USER_FOLLOW_MODIFY("user-follow-modify"),
    /**
     * Access your followers and who you are following.
     */
    USER_FOLLOW_READ("user-follow-read"),
    /**
     * Manage your saved content.
     */
    USER_LIBRARY_MODIFY("user-library-modify"),
    /**
     * Access your saved content.
     */
    USER_LIBRARY_READ("user-library-read"),
    /**
     * Control playback on your Spotify clients and Spotify Connect devices.
     */
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),
    /**
     * Read your currently playing content.
     */
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),
    /**
     * Get your real email address.
     */
    USER_READ_EMAIL("user-read-email"),
    /**
     * Read your position in content you have played.
     */
    USER_READ_PLAYBACK_POSITION("user-read-playback-position"),
    /**
     * Read your currently playing content and Spotify Connect devices information.
     */
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),
    /**
     * Access your subscription details.
     */
    USER_READ_PRIVATE("user-read-private"),
    /**
     * Access your recently played items.
     */
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),
    /**
     * Read your top artists and content.
     */
    USER_TOP_READ("user-top-read");

    private final String scopeName;

    Scope(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getName() {
        return scopeName;
    }
}
