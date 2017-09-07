package jsone_studios.wrapper.spotify;

public interface SpotifyService
{
    /**
     * The maximum number of objects to return.
     */
    String LIMIT = "limit";

    /**
     * The index of the first playlist to return. Default: 0 (the first object).
     * Use with limit to get the next set of objects (albums, playlists, etc).
     */
    String OFFSET = "offset";

    /**
     * A comma-separated list of keywords that will be used to filter the response.
     * Valid values are: {@code album}, {@code single}, {@code appears_on}, {@code compilation}
     */
    String ALBUM_TYPE = "album_type";

    /**
     * The country: an ISO 3166-1 alpha-2 country code.
     * Limit the response to one particular geographical market.
     * Synonym to {@link #COUNTRY}
     */
    String MARKET = "market";

    /**
     * Same as {@link #MARKET}
     */
    String COUNTRY = "country";

    /**
     * The desired language, consisting of a lowercase ISO 639 language code
     * and an uppercase ISO 3166-1 alpha-2 country code, joined by an underscore.
     * For example: es_MX, meaning "Spanish (Mexico)".
     */
    String LOCALE = "locale";

    /**
     * Filters for the query: a comma-separated list of the fields to return.
     * If omitted, all fields are returned.
     */
    String FIELDS = "fields";

    /**
     * A timestamp in ISO 8601 format: yyyy-MM-ddTHH:mm:ss. Use this parameter to
     * specify the user's local time to get results tailored for that specific date
     * and time in the day. If not provided, the response defaults to the current UTC time
     */
    String TIMESTAMP = "timestamp";

    String TIME_RANGE = "time_range";
}
