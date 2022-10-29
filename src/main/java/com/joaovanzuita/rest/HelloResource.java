package com.joaovanzuita.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

	@GET
	public String get() {
		return "HTTP GET";
	}
	
	@PUT
	public String put() {
		return "HTTP PUT";
	}
	
	@POST
	public String post() {
		return "HTTP POST";
	}
	
	@DELETE
	public String delete() {
		return "HTTP DELETE";
	}
}
