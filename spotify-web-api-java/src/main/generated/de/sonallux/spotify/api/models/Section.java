package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SectionObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Section {
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the section's &quot;designation&quot;.</p>
     */
    public float confidence;
    /**
     * <p>The duration (in seconds) of the section.</p>
     */
    public float duration;
    /**
     * <p>The estimated overall key of the section. The values in this field ranging from 0 to 11 mapping to pitches using standard Pitch Class notation (E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on). If no key was detected, the value is -1.</p>
     */
    public int key;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the key. Songs with many key changes may correspond to low values in this field.</p>
     */
    public float keyConfidence;
    /**
     * <p>The overall loudness of the section in decibels (dB). Loudness values are useful for comparing relative loudness of sections within tracks.</p>
     */
    public float loudness;
    /**
     * <p>Indicates the modality (major or minor) of a section, the type of scale from which its melodic content is derived. This field will contain a 0 for &quot;minor&quot;, a 1 for &quot;major&quot;, or a -1 for no result. Note that the major key (e.g. C major) could more likely be confused with the minor key at 3 semitones lower (e.g. A minor) as both keys carry the same pitches.</p>
     */
    public float mode;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>mode</code>.</p>
     */
    public float modeConfidence;
    /**
     * <p>The starting point (in seconds) of the section.</p>
     */
    public float start;
    /**
     * <p>The overall estimated tempo of the section in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration.</p>
     */
    public float tempo;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the tempo. Some tracks contain tempo changes or sounds which don't contain tempo (like pure speech) which would correspond to a low value in this field.</p>
     */
    public float tempoConfidence;
    /**
     * <p>An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of &quot;3/4&quot;, to &quot;7/4&quot;.</p>
     */
    public int timeSignature;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>time_signature</code>. Sections with time signature changes may correspond to low values in this field.</p>
     */
    public float timeSignatureConfidence;
}
