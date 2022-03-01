package jaxrs.learn.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jaxrs.learn.model.Employee;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Client client = ClientBuilder.newClient();
		
		Employee employee = new Employee();
		employee.setCpr(123);
		employee.setName("Hasan");
		
		Response result = client
				.target("http://localhost:8080/JAX-RS/saveEmployee")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.json(employee));
		
		employee = result.readEntity(Employee.class);
		
		response.getWriter().println(employee);
		
		client = ClientBuilder.newClient();
		
		employee = client
				.target("http://localhost:8080/JAX-RS/getEmployee")
				.request(MediaType.APPLICATION_JSON)
				.get(Employee.class);
		
		response.getWriter().println(employee);
	}
}
