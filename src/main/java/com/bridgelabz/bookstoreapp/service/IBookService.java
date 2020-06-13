package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.exception.BookException;
import com.bridgelabz.bookstoreapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    List<Book> getBooksByFilter(String filter) throws BookException;

    List<Book> getBooksByIdIn(Long[] ids);
}
