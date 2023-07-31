package com.aws.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.bookstore.entity.Book;
import com.aws.bookstore.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		System.out.println("Inside addBook"+book.toString());
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
