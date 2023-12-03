package de.sonallux.spotify.api.models;

import lombok.*;

/**
 * DeviceObject
 */
@Getter
@Setter
@NoArgsConstructor
public class Device {
    /**
     * <p>The device ID. This ID is unique and persistent to some extent. However, this is not guaranteed and any cached <code>device_id</code> should periodically be cleared out and refetched as necessary.</p>
     */
    public String id;
    /**
     * <p>If this device is the currently active device.</p>
     */
    public boolean isActive;
    /**
     * <p>If this device is currently in a private session.</p>
     */
    public boolean isPrivateSession;
    /**
     * <p>Whether controlling this device is restricted. At present if this is &quot;true&quot; then no Web API commands will be accepted by this device.</p>
     */
    public boolean isRestricted;
    /**
     * <p>A human-readable name for the device. Some devices have a name that the user can configure (e.g. &quot;Loudest speaker&quot;) and some devices have a generic name associated with the manufacturer or device model.</p>
     */
    public String name;
    /**
     * <p>If this device can be used to set the volume.</p>
     */
    public boolean supportsVolume;
    /**
     * <p>Device type, such as &quot;computer&quot;, &quot;smartphone&quot; or &quot;speaker&quot;.</p>
     */
    public String type;
    /**
     * <p>The current volume in percent.</p>
     */
    public int volumePercent;
}
