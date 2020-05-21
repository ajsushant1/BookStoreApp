package com.bridgelabz.bookstoreapp.book.controller;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;
import com.bridgelabz.bookstoreapp.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    final
    IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get-books/{filter}")
    public List<Book> getBooksByFilter(@PathVariable String filter) throws BookException {
        return bookService.getBookByFilter(filter);
    }
}
