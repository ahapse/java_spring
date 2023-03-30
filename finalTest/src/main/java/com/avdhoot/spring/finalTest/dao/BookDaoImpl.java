package com.avdhoot.spring.finalTest.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.avdhoot.spring.finalTest.entities.Book;


public class BookDaoImpl implements BookDao{
	
	private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate geTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}

	@Override
	public Book updateBook(Book book) {
		String queryString = "update Books set BookName=?, ISBNNumber=? , Author=?, Genre=? where BookID = ?;";
		this.jdbcTemp.update(queryString, book.getBookNameString(), book.getIsbnNumberString(), book.getAuthorString(), book.getGenreString(), book.getBookID());
		return book;
	}

	@Override
	public String deleteBook(int id) {
		String queryString = "delete from Books where BookID = ?;";
		this.jdbcTemp.update(queryString, id);
		return ("successfully deleted book with id = "+id);
	}

	@Override
	public Book getBook(int id) {
		try {
			String queryString = "select * from Books where BookID = ?;";
			RowMapper<Book> rowMapper = new RowMapperImpl();
			Book book = this.jdbcTemp.queryForObject(queryString, rowMapper, id);
			return book;
		} catch (Exception e) {
			return new Book();
		}
		
	}

	@Override
	public List<Book> getBooksUpToPageSize(int pageSize) {
		String queryString = "select * from Books order by BookName LIMIT ?;";
		List<Book> books = this.jdbcTemp.query(queryString, new RowMapperImpl(), pageSize);
		return books;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		String queryString = "select * from Books where Author = ?;";
		List<Book> books = this.jdbcTemp.query(queryString, new RowMapperImpl(), author);
		return books;
	}

	@Override
	public List<Book> getBooksByGenre(String genre) {
		String queryString = "select * from Books where Genre = ?;";
		List<Book> books = this.jdbcTemp.query(queryString, new RowMapperImpl(), genre);
		return books;
	}

	@Override
	public Book addBook(Book book) {
		String queryString = "insert into Books(BookID, BookName, ISBNNumber, Author, Genre) values(?,?,?,?,?);";
		this.jdbcTemp.update(queryString, book.getBookID(), book.getBookNameString(), book.getIsbnNumberString(), book.getAuthorString(), book.getGenreString());
		return book;
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