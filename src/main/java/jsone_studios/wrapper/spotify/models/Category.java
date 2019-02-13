package jsone_studios.wrapper.spotify.models;

import java.util.List;

/**
 * <a href="https://developer.spotify.com/documentation/web-api/reference/object-model/#category-object">Category object model</a>
 */
public class Category
{
    public String href;
    public List<Image> icons;
    public String id;
    public String name;

    public Category()
    {
    }
}
