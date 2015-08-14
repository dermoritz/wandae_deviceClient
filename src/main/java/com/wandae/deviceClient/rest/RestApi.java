package com.wandae.deviceClient.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.wandae.common.device.IdentifiableDevice;

@Path("/check")
@RequestScoped
public class RestApi {

	/**
	 * Logger.
	 */
	@Inject
	private Logger log;

	/**
	 * Produces device info on demand.
	 */
	@Inject
	private Provider<IdentifiableDevice> deviceInfo;

	@GET
	@Path("/alive")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response amIalive(@Context HttpServletRequest request) {
		log.debug(request.getRemoteHost() + "(ip: " + request.getRemoteAddr() + ")" + " requested alive status.");
		return Response.ok(deviceInfo.get()).build();
	}

}
