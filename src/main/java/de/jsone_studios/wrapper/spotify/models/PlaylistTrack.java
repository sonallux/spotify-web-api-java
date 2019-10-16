package de.jsone_studios.wrapper.spotify.models;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#playlist-track-object">Playlist track object model</a>
 */
public class PlaylistTrack
{
    public String added_at;
    public UserPublic added_by;
    public Track track;
    public boolean is_local;

    public PlaylistTrack()
    {
    }
}
