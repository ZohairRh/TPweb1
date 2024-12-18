package urn.mastersid.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello/{msg}")
public class HelloREST {
	
	private String message;
	
	public HelloREST(@PathParam("msg") String msg) {
		this.message = msg;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello " + this.message;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello(){
		return "<strong>Hello " + this.message + "</strong>";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello " + this.message + "</hello>";
	}
}
