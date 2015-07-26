package com.wandae.deviceClient.cdi;

import java.util.UUID;

import javax.enterprise.inject.Produces;

public class DeviceIdProvider {

	@Produces
	@DeviceId
	public String getDeviceId() {
		// TODO the uuid must be stored on device and only be generated on fist
		// start of the application.
		return UUID.randomUUID().toString();
	}

}
