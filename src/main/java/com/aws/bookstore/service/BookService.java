package com.aws.bookstore.service;

import java.util.List;

import com.aws.bookstore.entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public List<Book> getBook(Long bookId);
	
	public String deleteBook(Book book);

}
