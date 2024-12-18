package urn.mastersid.hello;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class HelloClient {

	public static void main(String[] args) {
		
		// 1 - get the client
		Client client = ClientBuilder.newClient();

		// 2 - build the target base URI
        WebTarget target = client.target("http://localhost:8080/BookREST/api/");

        // 3.1 - submit the HTTP request and retrieve the response as a Response object
        Response response = target.path("hello").path("MasterSID")	// "MasterSID" is the message
                            .request()
                            .accept(MediaType.TEXT_PLAIN)
                            .get(Response.class);
		
        // 3.2 - or get the response as a String
		String msg_plain = target.path("hello").path("MasterSID").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String msg_html = target.path("hello").path("MasterSID").request().accept(MediaType.TEXT_HTML).get(String.class);
		String msg_xml = target.path("hello").path("MasterSID").request().accept(MediaType.TEXT_XML).get(String.class);

		System.out.println(response);
		System.out.println(msg_plain);
		System.out.println(msg_html);
		System.out.println(msg_xml);
	}
	
}

