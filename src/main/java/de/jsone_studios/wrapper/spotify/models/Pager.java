package de.jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#paging-object">Paging object model</a>
 *
 * @param <T> expected object that is paged
 */
public class Pager<T>
{
    public String href;
    public List<T> items;
    public int limit;
    public String next;
    public int offset;
    public String previous;
    public int total;

    public Pager()
    {
    }
}
