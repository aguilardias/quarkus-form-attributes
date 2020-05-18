package org.acme.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import io.vertx.core.http.HttpServerRequest;

@Provider
public class AuditFilter implements ContainerRequestFilter {

	@Context
	HttpServerRequest request;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("jax-rs filter");

		request.setExpectMultipart(true);
		request.endHandler(v -> {
			System.out.println("endHandler");
			try {
				request.formAttributes().forEach(f -> {
					System.out.println("key: " + f.getKey());
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

}
