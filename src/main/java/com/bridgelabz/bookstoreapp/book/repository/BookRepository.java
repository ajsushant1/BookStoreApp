package com.bridgelabz.bookstoreapp.book.repository;

import com.bridgelabz.bookstoreapp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByBookAuthorOrBookTitle(String bookAuthor, String bookTitle);
}
