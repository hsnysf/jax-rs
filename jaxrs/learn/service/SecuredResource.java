package jaxrs.learn.service;

import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jaxrs.learn.annotation.Secured;
import jaxrs.learn.interceptor.SecuredMethodInterceptor;
import jaxrs.learn.model.Employee;

@Path("/")
public class SecuredResource {

	@Interceptors(SecuredMethodInterceptor.class)
	@Secured
	@Path("deleteEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee deleteEmployee(Employee employee) {
		
		return employee;
	}
}
