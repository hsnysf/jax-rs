package jaxrs.learn.interceptor;

import java.io.IOException;
import java.util.Base64;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import jaxrs.learn.annotation.Secured;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityInterceptor implements ContainerRequestFilter {

	Response response = Response.status(Status.UNAUTHORIZED).entity("You are Not Authoized").build();
	
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		
		//Basic Base64Value
		String auth = context.getHeaderString("Authorization");
		
		if(auth != null && auth.split(" ").length == 2) {
			
			String token = auth.split(" ")[1];
			
			String values = new String(Base64.getDecoder().decode(token));
			
			//hasan:hasan
			String user = values.split(":")[0];
			
			String password = values.split(":")[1];
			
			if(!"hasan".equals(user) || !"hasan".equals(password)) {
			
				context.abortWith(response);
			}
			
		}else {
			
			context.abortWith(response);
		}
	}
}
