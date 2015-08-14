package com.wandae.deviceClient.device;

import java.util.Date;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;
import com.wandae.deviceClient.cdi.DeviceId;

@XmlRootElement(name = "device", namespace = "urn:com.wandae:device")
public class DeviceInfoImpl implements DeviceInfo {

    @NotNull
    @Inject
    @DeviceId
    private String deviceId;

    /**
     * Date and time of this information.
     */
    private Date time = new Date();

    private Object sensorData;

    private Object metaData;

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        if (Strings.isNullOrEmpty(deviceId)) {
            throw new IllegalArgumentException("Device id must not null nor empty.");
        }
        this.deviceId = deviceId;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    @Override
    public Object getSensorData() {
        return sensorData;
    }

    @Override
    public Object getMetaData() {
        return metaData;
    }

    public void setMetaData(Object metaData) {
        this.metaData = metaData;
    }

    public void setSensorData(Object sensorData) {
        this.sensorData = sensorData;
    }

    /**
     * @param time
     *            the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

}