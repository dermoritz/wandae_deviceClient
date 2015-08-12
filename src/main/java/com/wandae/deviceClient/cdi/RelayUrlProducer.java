package com.wandae.deviceClient.cdi;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.inject.Produces;

public class RelayUrlProducer {
	@Produces
	@RelayUrl
	public URL getRelayUrl(){
		String urlS = "";
		try {
			return new URL(urlS);
		} catch (MalformedURLException e) {
			throw new IllegalStateException("Problem on parsing " + urlS + " as URL.: ", e);
		}
	}
}
