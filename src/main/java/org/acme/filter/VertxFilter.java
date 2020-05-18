package org.acme.filter;

import io.quarkus.vertx.web.RouteFilter;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class VertxFilter {

	@RouteFilter(100)
	void myFilter(RoutingContext rc) {
		System.out.println("vertx filter");

		HttpServerRequest request = rc.request();
		request.setExpectMultipart(true);
		request.endHandler(h -> {
			try {
				request.formAttributes().forEach(f -> {
					System.out.println("key: " + f.getKey());
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			// if rc.next is called inside 'endHandler', i can see just UserForm.name field,
			// no UserForm.photo is seen
			// and the ExampleResource.multipart dont receive form data
//			rc.next();
		});

		// if rc.next is called outside 'endHandler', i cant see just UserForm fields
		// and the ExampleResource.multipart receive form data
		rc.next();
	}
}
