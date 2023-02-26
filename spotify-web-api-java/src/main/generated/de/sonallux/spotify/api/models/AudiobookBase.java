package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * AudiobookBase
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class AudiobookBase extends BaseObject {
    /**
     * <p>The author(s) for the audiobook.</p>
     */
    public java.util.List<Author> authors;
    /**
     * <p>A list of the countries in which the audiobook can be played, identified by their <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> code.</p>
     */
    public java.util.List<String> availableMarkets;
    /**
     * <p>The copyright statements of the audiobook.</p>
     */
    public java.util.List<Copyright> copyrights;
    /**
     * <p>A description of the audiobook. HTML tags are stripped away from this field, use <code>html_description</code> field in case HTML tags are needed.</p>
     */
    public String description;
    /**
     * <p>The edition of the audiobook.</p>
     */
    public String edition;
    /**
     * <p>Whether or not the audiobook has explicit content (true = yes it does; false = no it does not OR unknown).</p>
     */
    public boolean explicit;
    /**
     * <p>External URLs for this audiobook.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A description of the audiobook. This field may contain HTML tags.</p>
     */
    public String htmlDescription;
    /**
     * <p>The cover art for the audiobook in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>A list of the languages used in the audiobook, identified by their <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639</a> code.</p>
     */
    public java.util.List<String> languages;
    /**
     * <p>The media type of the audiobook.</p>
     */
    public String mediaType;
    /**
     * <p>The name of the audiobook.</p>
     */
    public String name;
    /**
     * <p>The narrator(s) for the audiobook.</p>
     */
    public java.util.List<Narrator> narrators;
    /**
     * <p>The publisher of the audiobook.</p>
     */
    public String publisher;
    /**
     * <p>The number of chapters in this audiobook.</p>
     */
    public int totalChapters;
}
