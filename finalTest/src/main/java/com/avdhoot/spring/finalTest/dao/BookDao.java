package com.avdhoot.spring.finalTest.dao;

import java.util.List;

import com.avdhoot.spring.finalTest.entities.Book;

public interface BookDao {
	public Book addBook(Book book);
	public Book updateBook(Book book);
	public String deleteBook(int id);
	public Book getBook(int id);
	public List<Book> getBooksUpToPageSize(int pageSize);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByGenre(String genre);
}


//API Required:
//1- Authenticate your API using JWT Token (Token generation + validation).
//2- Add a book with the above-mentioned fields (take input in JSON format).
//3- Update book details by book id (take input as JSON format).
//4- Delete book details by book id (take input as path parameter).
//5- Fetch a single book detail by book id (take input as path parameter).
//6- Fetch and return books up to pageSize passed by the user. Sort by BookName in Ascending Order (take inputs as a query parameter).
//7- Search and return the books on the basis of author and genre (take inputs as a query parameter).