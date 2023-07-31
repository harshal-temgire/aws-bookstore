package com.aws.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//	public Book addBook(Book book);
//
//	public Book getBook(Long bookId);
//
//	public String deleteBook(Book book);

}
