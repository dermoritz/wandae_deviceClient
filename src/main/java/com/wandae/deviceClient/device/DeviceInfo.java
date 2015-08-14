package com.wandae.deviceClient.device;

import java.util.Date;

/**
 * Created by moritz on 13.08.2015.
 */
public interface DeviceInfo  extends IdentifiableDevice{

    /**
     *
     * @return the time stamp of this
     */
    Date getTime();

    /**
     * Arbitrary data the device provides via it's io interface (sensor reads).
     * @return raw sensor data as object
     */
    Object getSensorData();

    /**
     * Used to describe the device or general meta data also operation meta data or provided service endpoint.
     * @return meta data
     */
    Object getMetaData();

}
