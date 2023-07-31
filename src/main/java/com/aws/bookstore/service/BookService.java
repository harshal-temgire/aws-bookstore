package com.aws.bookstore.service;

import java.util.List;
import com.aws.bookstore.entity.Book;

public interface BookService {
	
	public Book addBook(Book book);
	
	public void deleteBook(Long bookId);

	public List<Book> getAllBooks();

	Book getBookById(Long bookId);

}
