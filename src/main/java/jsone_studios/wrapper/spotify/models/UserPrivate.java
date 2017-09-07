package jsone_studios.wrapper.spotify.models;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#user-object-private">User object (private) model</a>
 */
public class UserPrivate extends UserPublic
{
    public String birthdate;
    public String country;
    public String email;
    public String product;

    public UserPrivate()
    {
    }
}
