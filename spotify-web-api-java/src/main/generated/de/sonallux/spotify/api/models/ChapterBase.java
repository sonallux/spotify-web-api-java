package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * ChapterBase
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class ChapterBase extends BaseObject {
    /**
     * <p>A URL to a 30 second preview (MP3 format) of the chapter. <code>null</code> if not available.</p>
     */
    public String audioPreviewUrl;
    /**
     * <p>A list of the countries in which the chapter can be played, identified by their <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> code.</p>
     */
    public java.util.List<String> availableMarkets;
    /**
     * <p>The number of the chapter</p>
     */
    public int chapterNumber;
    /**
     * <p>A description of the chapter. HTML tags are stripped away from this field, use <code>html_description</code> field in case HTML tags are needed.</p>
     */
    public String description;
    /**
     * <p>The chapter length in milliseconds.</p>
     */
    public int durationMs;
    /**
     * <p>Whether or not the chapter has explicit content (true = yes it does; false = no it does not OR unknown).</p>
     */
    public boolean explicit;
    /**
     * <p>External URLs for this chapter.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A description of the chapter. This field may contain HTML tags.</p>
     */
    public String htmlDescription;
    /**
     * <p>The cover art for the chapter in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>True if the chapter is playable in the given market. Otherwise false.</p>
     */
    public boolean isPlayable;
    /**
     * <p>A list of the languages used in the chapter, identified by their <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639-1</a> code.</p>
     */
    public java.util.List<String> languages;
    /**
     * <p>The name of the chapter.</p>
     */
    public String name;
    /**
     * <p>The date the chapter was first released, for example <code>&quot;1981-12-15&quot;</code>. Depending on the precision, it might be shown as <code>&quot;1981&quot;</code> or <code>&quot;1981-12&quot;</code>.</p>
     */
    public String releaseDate;
    /**
     * <p>The precision with which <code>release_date</code> value is known.</p>
     */
    public String releaseDatePrecision;
    /**
     * <p>Included in the response when a content restriction is applied.</p>
     */
    public ChapterRestriction restrictions;
    /**
     * <p>The user's most recent position in the chapter. Set if the supplied access token is a user token and has the scope 'user-read-playback-position'.</p>
     */
    public ResumePoint resumePoint;
}
