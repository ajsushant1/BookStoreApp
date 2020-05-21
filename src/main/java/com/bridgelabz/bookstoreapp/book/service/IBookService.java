package com.bridgelabz.bookstoreapp.book.service;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    List<Book> getBookByFilter(String filter) throws BookException;
}
