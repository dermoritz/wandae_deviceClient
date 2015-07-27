package com.wandae.deviceClient.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.google.common.base.Strings;
import com.jayway.restassured.RestAssured;
import com.wandae.deviceClient.ArquillianClientTest;
import com.wandae.deviceClient.device.DeviceInfo;

public class RestApiTest extends ArquillianClientTest {
    /**
     * Path to alive endpoint relative to deployed app.
     */
    private static final String ALIVE_PATH = "rest/check/alive";


    @Test
    public void aliveTest() throws MalformedURLException {
        URL aliveUrl = new URL(base, ALIVE_PATH);
        DeviceInfo deviceInfo = RestAssured.given().then().contentType(MediaType.APPLICATION_JSON)
                                           .statusCode(Status.OK.getStatusCode()).when().get(aliveUrl).body()
                                           .as(DeviceInfo.class);
        assertNotNull(deviceInfo);
        assertFalse(Strings.isNullOrEmpty(deviceInfo.getDeviceId()));
    }
}
