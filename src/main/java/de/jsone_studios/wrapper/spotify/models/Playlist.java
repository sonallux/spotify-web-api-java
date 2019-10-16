package de.jsone_studios.wrapper.spotify.models;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#playlist-object-full">Playlist object model</a>
 */
public class Playlist extends PlaylistBase
{
    public String description;
    public Followers followers;
    public Pager<PlaylistTrack> tracks;

    public Playlist()
    {
    }
}