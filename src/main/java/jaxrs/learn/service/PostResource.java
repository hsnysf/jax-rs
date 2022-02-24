package jaxrs.learn.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jaxrs.learn.interceptor.MethodInterceptor;
import jaxrs.learn.model.Employee;

@Interceptors(MethodInterceptor.class)
@Path("/")
public class PostResource {
	
	@PostConstruct
	public void initialize() {
		
		System.out.println("initialize()");
	}
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {

		System.out.println("before aroundInvoke == " + context.getTarget());
		
		Object object = context.proceed();
		
		System.out.println("after aroundInvoke == " + context.getTarget());
		
		return object;
	}
	
	@PreDestroy
	void cleanup() {
		
		System.out.println("cleanup()");
	}

	@Path("hello")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(String name) {
		
		return "Hello " + name;
	}
	
	@Path("updateEmployee/{name}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(@QueryParam("cpr") int cpr, @PathParam("name") String name, @MatrixParam("age") int age, @HeaderParam("email") String email, @CookieParam("id") int id, @FormParam("department") String department) {
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setCpr(cpr);
		employee.setName(name);
		employee.setAge(age);
		employee.setEmail(email);
		employee.setDepartment(department);
		
		return employee;
	}
	
	@Path("updateEmployeeDetails/{name}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployeeDetails(@BeanParam Employee employee) {
		
		return employee;
	}
	
	@Path("saveEmployee")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee saveEmployee(Employee employee) {
		
		return employee;
	}
}
