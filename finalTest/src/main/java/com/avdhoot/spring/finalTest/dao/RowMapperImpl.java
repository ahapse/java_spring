package com.avdhoot.spring.finalTest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avdhoot.spring.finalTest.entities.Book;

public class RowMapperImpl implements RowMapper<Book> {
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		
		book.setBookID(rs.getInt(1));
		book.setBookNameString(rs.getString(2));
		book.setIsbnNumberString(rs.getString(3));
		book.setAuthorString(rs.getString(4));
		book.setGenreString(rs.getString(5));
		
		return book;
	}

}

