package com.bridgelabz.bookstoreapp.book.repository;

import com.bridgelabz.bookstoreapp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Method to get all books after filtering with the search text
    List<Book> findBooksByBookAuthorContainsOrBookTitleContains(String bookAuthor, String bookTitle);
    List<Book> findByOrderByBookPrice();
    List<Book> findByOrderByBookPriceDesc();
    List<Book> findByOrderByBookQuantity();
}
