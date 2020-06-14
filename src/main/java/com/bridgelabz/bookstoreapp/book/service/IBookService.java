package com.bridgelabz.bookstoreapp.book.service;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    List<Book> getBooksByFilter(String filter) throws BookException;

    List<Book> getBooksByIdIn(Long[] ids);

    List<Book> getBooksBySort(String sort);
}
