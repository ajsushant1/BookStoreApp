package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findByOrderByBookPrice();

    List<Book> findByOrderByBookPriceDesc();

    List<Book> findByOrderByBookQuantity();

    List<Book> findBooksByBookAuthorContainsOrBookTitleContains(String bookAuthor, String bookTitle);
}
