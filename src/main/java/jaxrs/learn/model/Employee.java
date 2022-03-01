package jaxrs.learn.model;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	@CookieParam("id")
	private int id;
	@QueryParam("cpr")
	private int cpr;
	@PathParam("name")
	private String name;
	@MatrixParam("age")
	private int age;
	@HeaderParam("email")
	private String email;
	@FormParam("department")
	private String department;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCpr() {
		return cpr;
	}
	
	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", cpr=" + cpr + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", department=" + department + "]";
	}
}
