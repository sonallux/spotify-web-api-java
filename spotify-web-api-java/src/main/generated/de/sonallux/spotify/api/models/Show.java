package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class Show extends BaseObject {
    /**
     * <p>A list of the countries in which the show can be played, identified by their <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> code.</p>
     */
    public java.util.List<String> availableMarkets;
    /**
     * <p>The copyright statements of the show.</p>
     */
    public java.util.List<Copyright> copyrights;
    /**
     * <p>A description of the show. HTML tags are stripped away from this field, use <code>html_description</code> field in case HTML tags are needed.</p>
     */
    public String description;
    /**
     * <p>A list of the show's episodes.</p>
     */
    public Paging<SimplifiedEpisode> episodes;
    /**
     * <p>Whether or not the show has explicit content (true = yes it does; false = no it does not OR unknown).</p>
     */
    public boolean explicit;
    /**
     * <p>External URLs for this show.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A description of the show. This field may contain HTML tags.</p>
     */
    public String htmlDescription;
    /**
     * <p>The cover art for the show in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>True if all of the show's episodes are hosted outside of Spotify's CDN. This field might be <code>null</code> in some cases.</p>
     */
    public boolean isExternallyHosted;
    /**
     * <p>A list of the languages used in the show, identified by their <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639</a> code.</p>
     */
    public java.util.List<String> languages;
    /**
     * <p>The media type of the show.</p>
     */
    public String mediaType;
    /**
     * <p>The name of the episode.</p>
     */
    public String name;
    /**
     * <p>The publisher of the show.</p>
     */
    public String publisher;
}
