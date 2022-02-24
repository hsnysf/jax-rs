package jaxrs.learn.interceptor;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		
		System.out.println(context.getMethod() + " " + context.getUriInfo().getAbsolutePath());
		
		//for (String key : context.getHeaders().keySet()) {
			//System.out.println(key + ": " + context.getHeaders().get(key));
		//}
	}
	
	@Override
	public void filter(ContainerRequestContext context, ContainerResponseContext responseContext) throws IOException {
		
		//for (String key : context.getHeaders().keySet()) {
			
			//System.out.println(key + ": " + context.getHeaders().get(key));
		//}
	}
}
