package com.wandae.deviceClient.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Strings;
import com.jayway.restassured.RestAssured;
import com.wandae.deviceClient.device.DeviceInfo;

@RunWith(Arquillian.class)
public class RestApiTest {
    /**
     * Path to alive endpoint relative to deployed app.
     */
    private static final String ALIVE_PATH = "rest/check/alive";

    @Deployment(testable = false)
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class, "test.war").addAsResource("META-INF/beans.xml")
                         .addPackages(true, "com.wandae.deviceClient").addClasses(Strings.class);
    }

    @ArquillianResource
    private URL base;

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
