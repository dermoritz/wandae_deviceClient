package com.wandae.deviceClient.device;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;
import com.wandae.deviceClient.cdi.DeviceId;

@XmlRootElement(name = "device", namespace ="urn:com.wandae:device")
public class DeviceInfo implements IdentifiableDevice {
	
	@NotNull
	@Inject
	@DeviceId
	private String deviceId;
	
	@Override
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		if(Strings.isNullOrEmpty(deviceId)){
			throw new IllegalArgumentException("Device id must not null nor empty.");
		}
		this.deviceId = deviceId;
	}

}
