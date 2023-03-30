package com.avdhoot.spring.finalTest.entities;

public class Book {
	private int bookID;
	private String bookNameString;
	private String isbnNumberString;
	private String authorString;
	private String genreString;
	
	@Override
	public String toString() {
		return "Book [BookId=" + bookID + ", bookNameString=" + bookNameString + ", isbnNumberString="
				+ isbnNumberString + ", authorString=" + authorString + ", genreString=" + genreString + "]";
	}

	public int getBookID() {
		return bookID;
	}
	
	public void setBookID(int bookId) {
		bookID = bookId;
	}
	
	public String getBookNameString() {
		return bookNameString;
	}
	
	public void setBookNameString(String bookNameString) {
		this.bookNameString = bookNameString;
	}
	
	public String getIsbnNumberString() {
		return isbnNumberString;
	}
	
	public void setIsbnNumberString(String isbnNumberString) {
		this.isbnNumberString = isbnNumberString;
	}
	
	public String getAuthorString() {
		return authorString;
	}
	
	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}
	
	public String getGenreString() {
		return genreString;
	}
	
	public void setGenreString(String genreString) {
		this.genreString = genreString;
	}
}



//Fields: BookId, BookName, ISBNNumber, Author, Genre.



