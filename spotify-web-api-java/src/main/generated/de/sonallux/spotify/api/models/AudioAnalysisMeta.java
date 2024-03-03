package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * 
 */
@Getter
@Setter
@NoArgsConstructor
public class AudioAnalysisMeta {
    /**
     * <p>The amount of time taken to analyze this track.</p>
     */
    public float analysisTime;
    /**
     * <p>The version of the Analyzer used to analyze this track.</p>
     */
    public String analyzerVersion;
    /**
     * <p>A detailed status code for this track. If analysis data is missing, this code may explain why.</p>
     */
    public String detailedStatus;
    /**
     * <p>The method used to read the track's audio data.</p>
     */
    public String inputProcess;
    /**
     * <p>The platform used to read the track's audio data.</p>
     */
    public String platform;
    /**
     * <p>The return code of the analyzer process. 0 if successful, 1 if any errors occurred.</p>
     */
    public int statusCode;
    /**
     * <p>The Unix timestamp (in seconds) at which this track was analyzed.</p>
     */
    public long timestamp;
}
