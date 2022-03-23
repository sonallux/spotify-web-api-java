package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * SegmentObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Segment {
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the segmentation. Segments of the song which are difficult to logically segment (e.g: noise) may correspond to low values in this field.</p>
     */
    public float confidence;
    /**
     * <p>The duration (in seconds) of the segment.</p>
     */
    public float duration;
    /**
     * <p>The offset loudness of the segment in decibels (dB). This value should be equivalent to the loudness_start of the following segment.</p>
     */
    public float loudnessEnd;
    /**
     * <p>The peak loudness of the segment in decibels (dB). Combined with <code>loudness_start</code> and <code>loudness_max_time</code>, these components can be used to describe the &quot;attack&quot; of the segment.</p>
     */
    public float loudnessMax;
    /**
     * <p>The segment-relative offset of the segment peak loudness in seconds. Combined with <code>loudness_start</code> and <code>loudness_max</code>, these components can be used to desctibe the &quot;attack&quot; of the segment.</p>
     */
    public float loudnessMaxTime;
    /**
     * <p>The onset loudness of the segment in decibels (dB). Combined with <code>loudness_max</code> and <code>loudness_max_time</code>, these components can be used to describe the &quot;attack&quot; of the segment.</p>
     */
    public float loudnessStart;
    /**
     * <p>Pitch content is given by a “chroma” vector, corresponding to the 12 pitch classes C, C#, D to B, with values ranging from 0 to 1 that describe the relative dominance of every pitch in the chromatic scale. For example a C Major chord would likely be represented by large values of C, E and G (i.e. classes 0, 4, and 7).</p>
     * <p>Vectors are normalized to 1 by their strongest dimension, therefore noisy sounds are likely represented by values that are all close to 1, while pure tones are described by one value at 1 (the pitch) and others near 0.
     * As can be seen below, the 12 vector indices are a combination of low-power spectrum values at their respective pitch frequencies.
     * <img alt="" src="https://developer.spotify.com/assets/audio/Pitch_vector.png" /></p>
     */
    public java.util.List<Float> pitches;
    /**
     * <p>The starting point (in seconds) of the segment.</p>
     */
    public float start;
    /**
     * <p>Timbre is the quality of a musical note or sound that distinguishes different types of musical instruments, or voices. It is a complex notion also referred to as sound color, texture, or tone quality, and is derived from the shape of a segment’s spectro-temporal surface, independently of pitch and loudness. The timbre feature is a vector that includes 12 unbounded values roughly centered around 0. Those values are high level abstractions of the spectral surface, ordered by degree of importance.</p>
     * <p>For completeness however, the first dimension represents the average loudness of the segment; second emphasizes brightness; third is more closely correlated to the flatness of a sound; fourth to sounds with a stronger attack; etc. See an image below representing the 12 basis functions (i.e. template segments).
     * <img alt="" src="https://developer.spotify.com/assets/audio/Timbre_basis_functions.png" /></p>
     * <p>The actual timbre of the segment is best described as a linear combination of these 12 basis functions weighted by the coefficient values: timbre = c1 x b1 + c2 x b2 + ... + c12 x b12, where c1 to c12 represent the 12 coefficients and b1 to b12 the 12 basis functions as displayed below. Timbre vectors are best used in comparison with each other.</p>
     */
    public java.util.List<Float> timbre;
}
