package com.aws.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.bookstore.entity.Book;
import com.aws.bookstore.repository.BookRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		System.out.println("Inside addBook"+book.toString());
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getBook(Long bookId) {
		return bookRepository.findAll();
	}

	@Override
	public String deleteBook(Book book) {
		return null;
	}

}
