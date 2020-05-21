package com.bridgelabz.bookstoreapp.book.repository;

import com.bridgelabz.bookstoreapp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByBookAuthor(String authorName);

    List<Book> findBooksByBookTitle(String bookTitle);
}
