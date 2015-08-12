package com.wandae.deviceClient.device;

/**
 * specifies method to identify a device by a string.
 * @author moritz
 *
 */
public interface IdentifiableDevice {
	/**
	 * Id specific to this device. Does not change after restart.
	 * 
	 * @return an id specific to this device
	 */
	String getDeviceId();
}
