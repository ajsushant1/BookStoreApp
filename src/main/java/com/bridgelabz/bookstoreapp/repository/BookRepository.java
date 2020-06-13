package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Method to get all books after filtering with the search text
    List<Book> findBooksByBookAuthorContainsOrBookTitleContains(String bookAuthor, String bookTitle);
}
