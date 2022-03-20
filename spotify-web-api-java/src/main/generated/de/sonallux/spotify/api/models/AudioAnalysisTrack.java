package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class AudioAnalysisTrack {
    /**
     * <p>The number of channels used for analysis. If 1, all channels are summed together to mono before analysis.</p>
     */
    public int analysisChannels;
    /**
     * <p>The sample rate used to decode and analyze this track. May differ from the actual sample rate of this track available on Spotify.</p>
     */
    public int analysisSampleRate;
    /**
     * <p>A version number for the Echo Nest Musical Fingerprint format used in the codestring field.</p>
     */
    public float codeVersion;
    /**
     * <p>An <a href="https://academiccommons.columbia.edu/doi/10.7916/D8Q248M4">Echo Nest Musical Fingerprint (ENMFP)</a> codestring for this track.</p>
     */
    public String codestring;
    /**
     * <p>Length of the track in seconds.</p>
     */
    public float duration;
    /**
     * <p>A version number for the EchoPrint format used in the echoprintstring field.</p>
     */
    public float echoprintVersion;
    /**
     * <p>An <a href="https://github.com/spotify/echoprint-codegen">EchoPrint</a> codestring for this track.</p>
     */
    public String echoprintstring;
    /**
     * <p>The time, in seconds, at which the track's fade-in period ends. If the track has no fade-in, this will be 0.0.</p>
     */
    public float endOfFadeIn;
    /**
     * <p>The key the track is in. Integers map to pitches using standard <a href="https://en.wikipedia.org/wiki/Pitch_class">Pitch Class notation</a>. E.g. 0 = C, 1 = C♯/D♭, 2 = D, and so on. If no key was detected, the value is -1.</p>
     */
    public int key;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>key</code>.</p>
     */
    public float keyConfidence;
    /**
     * <p>The overall loudness of a track in decibels (dB). Loudness values are averaged across the entire track and are useful for comparing relative loudness of tracks. Loudness is the quality of a sound that is the primary psychological correlate of physical strength (amplitude). Values typically range between -60 and 0 db.</p>
     */
    public float loudness;
    /**
     * <p>Mode indicates the modality (major or minor) of a track, the type of scale from which its melodic content is derived. Major is represented by 1 and minor is 0.</p>
     */
    public int mode;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>mode</code>.</p>
     */
    public float modeConfidence;
    /**
     * <p>The exact number of audio samples analyzed from this track. See also <code>analysis_sample_rate</code>.</p>
     */
    public int numSamples;
    /**
     * <p>An offset to the start of the region of the track that was analyzed. (As the entire track is analyzed, this should always be 0.)</p>
     */
    public int offsetSeconds;
    /**
     * <p>A version number for the Rhythmstring used in the rhythmstring field.</p>
     */
    public float rhythmVersion;
    /**
     * <p>A Rhythmstring for this track. The format of this string is similar to the Synchstring.</p>
     */
    public String rhythmstring;
    /**
     * <p>This field will always contain the empty string.</p>
     */
    public String sampleMd5;
    /**
     * <p>The time, in seconds, at which the track's fade-out period starts. If the track has no fade-out, this should match the track's length.</p>
     */
    public float startOfFadeOut;
    /**
     * <p>A version number for the Synchstring used in the synchstring field.</p>
     */
    public float synchVersion;
    /**
     * <p>A <a href="https://github.com/echonest/synchdata">Synchstring</a> for this track.</p>
     */
    public String synchstring;
    /**
     * <p>The overall estimated tempo of a track in beats per minute (BPM). In musical terminology, tempo is the speed or pace of a given piece and derives directly from the average beat duration.</p>
     */
    public float tempo;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>tempo</code>.</p>
     */
    public float tempoConfidence;
    /**
     * <p>An estimated time signature. The time signature (meter) is a notational convention to specify how many beats are in each bar (or measure). The time signature ranges from 3 to 7 indicating time signatures of &quot;3/4&quot;, to &quot;7/4&quot;.</p>
     */
    public int timeSignature;
    /**
     * <p>The confidence, from 0.0 to 1.0, of the reliability of the <code>time_signature</code>.</p>
     */
    public float timeSignatureConfidence;
    /**
     * <p>The length of the region of the track was analyzed, if a subset of the track was analyzed. (As the entire track is analyzed, this should always be 0.)</p>
     */
    public int windowSeconds;
}
