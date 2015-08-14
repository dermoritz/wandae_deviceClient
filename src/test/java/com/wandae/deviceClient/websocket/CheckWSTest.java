package com.wandae.deviceClient.websocket;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.WebSocketContainer;

import org.jboss.arquillian.protocol.servlet.arq514hack.descriptors.impl.web.Strings;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wandae.deviceClient.ArquillianClientTest;
import com.wandae.deviceClient.device.DeviceInfoImpl;

public class CheckWSTest extends ArquillianClientTest {
    private static final String CHECK_PATH = "wscheck";
    private WebSocketContainer wsContainer;

    @Test
    public void testCheck() throws MalformedURLException, DeploymentException, IOException, URISyntaxException {
        wsContainer = ContainerProvider.getWebSocketContainer();
        String url = "ws://" + base.getHost() + ":" + base.getPort() + base.getPath() + CHECK_PATH;
        URI uri = new URI(url);
        wsContainer.connectToServer(new WsClient(), uri);
    }

    @ClientEndpoint
    public class WsClient {
        private ObjectMapper om = new ObjectMapper();
        @OnMessage
        public void onMessage(String message) throws JsonParseException, JsonMappingException, IOException {
            DeviceInfoImpl value = om.readValue(message, DeviceInfoImpl.class);
            assertNotNull(value);
            assertFalse(Strings.isNullOrEmpty(value.getDeviceId()));
            assertNotNull(value.getTime());
        }

    }
}
