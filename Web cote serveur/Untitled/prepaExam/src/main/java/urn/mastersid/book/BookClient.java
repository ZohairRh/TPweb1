package urn.mastersid.book;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class BookClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/JAXRSDemo/rest/books");
		String ress = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(ress);
	}

}
