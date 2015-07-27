package com.wandae.deviceClient.websocket;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.wandae.deviceClient.device.IdentifiableDevice;

@ServerEndpoint(value = "/wscheck", encoders = {JSONEncoder.class})
public class CheckWS {
    
    @Inject
    private Provider<IdentifiableDevice> deviceInfo;
    
    
    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        try {
            session.getBasicRemote().sendObject(deviceInfo.get());
        } catch (IOException | EncodeException e) {
            throw new IllegalStateException("Problem on sending message: ", e);
        }
    }
    
    
}
