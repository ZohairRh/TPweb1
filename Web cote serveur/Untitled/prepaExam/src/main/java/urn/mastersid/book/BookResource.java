package urn.mastersid.book;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import urn.mastersid.Book;
import urn.mastersid.Bookshelf;
import urn.mastersid.BookshelfManager;
import urn.mastersid.InvalidBookException;

@Path("/books")
public class BookResource {
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> get() {
		return BookshelfManager.getBookshelf().getAllBooks();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getByIndex(@PathParam("id") int id) {
		try {
			Bookshelf books = BookshelfManager.getBookshelf();
			Book book = books.get(id);
			return Response.ok(book).build();
		} catch(InvalidBookException e) {
			return Response.status(404).entity(e.getMessage()).build();
		}
    }

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("title") String title, @FormParam("author") String author, 
			@FormParam("rate") double rate, @FormParam("review") String review) throws URISyntaxException {
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setRate(rate);
		newBook.setReview(review);
		try {
			Bookshelf books = BookshelfManager.getBookshelf();
			books.add(newBook);
			URI uri = new URI("http://localhost:8080/BookREST/index.html");
			return Response.temporaryRedirect(uri).build();
		} catch (InvalidBookException e) {
			return Response.status(403).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/search")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Book> getByTitle(@QueryParam("author") String author, @QueryParam("title") String title) {
		// TODO

		Bookshelf books = BookshelfManager.getBookshelf();
		return books.getAllBooks();
    }
	
}
