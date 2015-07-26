package com.wandae.deviceClient.device;

public interface IdentifiableDevice {
	/**
	 * Id specific to this device. Does not change after restart.
	 * 
	 * @return an id specific to this device
	 */
	String getDeviceId();
}
