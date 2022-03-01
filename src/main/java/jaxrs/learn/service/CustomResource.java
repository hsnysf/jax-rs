package jaxrs.learn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jaxrs.learn.exception.RecordNotFoundException;
import jaxrs.learn.model.Employee;

@Path("/")
public class CustomResource {

	@Path("updateEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee employee) throws Exception {
		
		if(employee.getId() == 0) {
			
			throw new RecordNotFoundException("Employee Not Found");
		}
		
		return employee;
	}
	
	@Path("updateEmployeeDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeDetails(Employee employee) throws Exception {
		
		if(employee.getId() == 0) {
			
			return Response.status(Status.NOT_FOUND).entity("Record Not Found :: Employee Not Found").build();
		}
		
		return Response.status(Status.OK).entity(employee).build();
	}
	
	@Path("updateEmployeeInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployeeInfo(Employee employee) throws Exception {
		
		if(employee.getId() == 0) {
			
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity("Record Not Found :: Employee Not Found").build());
		}
		
		return employee;
	}
	
	@Context
	HttpServletRequest request;
	
	@Context
	HttpServletResponse response;
	
	@GET
	@Path("accessContext")
	public String accessContext() throws Exception {
		
		System.out.println(request.getRequestURL());
		
		response.addHeader("name", request.getParameter("name"));
		
		return request.getParameter("name");
	}
}
