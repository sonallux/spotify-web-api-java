package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * DevicesObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Devices {
    /**
     * <p>A list of 0..n Device objects</p>
     */
    public java.util.List<Device> devices;
}
