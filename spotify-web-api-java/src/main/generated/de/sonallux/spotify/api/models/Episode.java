package de.sonallux.spotify.api.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE) // Disable deserialization based on @JsonTypeInfo
public class Episode extends BaseObject {
    /**
     * <p>A URL to a 30 second preview (MP3 format) of the episode. <code>null</code> if not available.</p>
     */
    public String audioPreviewUrl;
    /**
     * <p>A description of the episode. HTML tags are stripped away from this field, use <code>html_description</code> field in case HTML tags are needed.</p>
     */
    public String description;
    /**
     * <p>The episode length in milliseconds.</p>
     */
    public int durationMs;
    /**
     * <p>Whether or not the episode has explicit content (true = yes it does; false = no it does not OR unknown).</p>
     */
    public boolean explicit;
    /**
     * <p>External URLs for this episode.</p>
     */
    public ExternalUrl externalUrls;
    /**
     * <p>A description of the episode. This field may contain HTML tags.</p>
     */
    public String htmlDescription;
    /**
     * <p>The cover art for the episode in various sizes, widest first.</p>
     */
    public java.util.List<Image> images;
    /**
     * <p>True if the episode is hosted outside of Spotify's CDN.</p>
     */
    public boolean isExternallyHosted;
    /**
     * <p>True if the episode is playable in the given market. Otherwise false.</p>
     */
    public boolean isPlayable;
    /**
     * <p><strong>Note: This field is deprecated and might be removed in the future. Please use the <code>languages</code> field instead.</strong> The language used in the episode, identified by a <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639</a> code.</p>
     */
    public String language;
    /**
     * <p>A list of the languages used in the episode, identified by their <a href="https://en.wikipedia.org/wiki/ISO_639">ISO 639</a> code.</p>
     */
    public java.util.List<String> languages;
    /**
     * <p>The name of the episode.</p>
     */
    public String name;
    /**
     * <p>The date the episode was first released, for example <code>&quot;1981-12-15&quot;</code>. Depending on the precision, it might be shown as <code>&quot;1981&quot;</code> or <code>&quot;1981-12&quot;</code>.</p>
     */
    public String releaseDate;
    /**
     * <p>The precision with which <code>release_date</code> value is known.</p>
     */
    public String releaseDatePrecision;
    /**
     * <p>Included in the response when a content restriction is applied. See <a href="https://developer.spotify.com/documentation/web-api/reference/#object-episoderestrictionobject">Restriction Object</a> for more details.</p>
     */
    public EpisodeRestriction restrictions;
    /**
     * <p>The user's most recent position in the episode. Set if the supplied access token is a user token and has the scope <code>user-read-playback-position</code>.</p>
     */
    public ResumePoint resumePoint;
    /**
     * <p>The show on which the episode belongs.</p>
     */
    public SimplifiedShow show;
}
