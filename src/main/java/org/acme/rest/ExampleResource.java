package org.acme.rest;

import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.form.UserForm;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/hello")
public class ExampleResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	@POST
	@Consumes(MULTIPART_FORM_DATA)
	@Produces(TEXT_PLAIN)
	public String multipart(@MultipartForm UserForm form) {
		System.out.println("rest controller");
//		System.out.println("name: " + form.name);
//		System.out.println("photo: " + form.photo);
		return "rest response";
	}
}