package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.exception.BookStoreException;
import com.bridgelabz.bookstoreapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBookList();

    List<Book> getBookByFilter(String filter) throws BookStoreException;

    List<Book> getBookById(Long[] id);

    List<Book> getBookBySort(String sort);

    Book addBook(BookDto bookDto);
}
