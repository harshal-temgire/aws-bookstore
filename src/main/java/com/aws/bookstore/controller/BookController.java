package com.aws.bookstore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.bookstore.entity.Book;
import com.aws.bookstore.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		System.out.println("inside controller"+book.toString()); 
		return bookService.addBook(book);
	}
	
	@GetMapping("/getBook")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getBook/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
		try {
			Book book = bookService.getBookById(bookId);
	        return new ResponseEntity<Book>(book, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	    } 
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}
}
