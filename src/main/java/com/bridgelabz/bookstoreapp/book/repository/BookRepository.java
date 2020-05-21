package com.bridgelabz.bookstoreapp.book.repository;

import com.bridgelabz.bookstoreapp.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
