package org.acme.form;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class UserForm {

	@FormParam("name")
	@PartType(TEXT_PLAIN)
	public String name;

	@FormParam("photo")
	@PartType(APPLICATION_OCTET_STREAM)
	public String photo;
}
