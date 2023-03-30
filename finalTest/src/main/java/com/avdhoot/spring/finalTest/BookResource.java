package com.avdhoot.spring.finalTest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avdhoot.spring.finalTest.dao.BookDao;
import com.avdhoot.spring.finalTest.entities.Book;

@Path("books")
public class BookResource {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("com/avdhoot/spring/finalTest/finalRest.xml");
	BookDao bookDao = context.getBean("BookDao", BookDao.class);

    
    @POST
    @Path("/book")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book createBook(Book book) {
    	return bookDao.addBook(book);
    }

    @PUT
    @Path("/book")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book updateBook(Book book) {
    	/**
    	 * if previously there is no book with the mentioned id for updating, it will create a new book.
    	 */
    	if((bookDao.getBook(book.getBookID())).getBookID() == 0) {
    		return bookDao.addBook(book);
    	}
    	/**
    	 * else it will update the previously present book.
    	 */
    	return bookDao.updateBook(book);
    }
    
    @DELETE
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteBook(@PathParam("id") int id) {
    	/**
    	 * if the given book id is not present return book not found.
    	 */
    	if((bookDao.getBook(id)).getBookID() == 0) {
    		return "No book with the given id present";
    	}
    	/**
    	 * else delete the book.
    	 */
    	return bookDao.deleteBook(id);
    }

    @GET
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") int id) {
    	return bookDao.getBook(id);
    }
    
    @GET
    @Path("/book/limit")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksUpToPageSize(@QueryParam("limit") int limit) {
    	return bookDao.getBooksUpToPageSize(limit);
    }
    
    @GET
    @Path("/book/author")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksByAuthor(@QueryParam("author") String author) {
    	return bookDao.getBooksByAuthor(author);
    }
    
    @GET
    @Path("/book/genre")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksByGenre(@QueryParam("genre") String genre) {
    	return bookDao.getBooksByGenre(genre);
    }
}



//API Required:
//1- Authenticate your API using JWT Token (Token generation + validation).
//2- Add a book with the above-mentioned fields (take input in JSON format).
//3- Update book details by book id (take input as JSON format).
//4- Delete book details by book id (take input as path parameter).
//5- Fetch a single book detail by book id (take input as path parameter).
//6- Fetch and return books up to pageSize passed by the user. Sort by BookName in Ascending Order (take inputs as a query parameter).
//7- Search and return the books on the basis of author and genre (take inputs as a query parameter).