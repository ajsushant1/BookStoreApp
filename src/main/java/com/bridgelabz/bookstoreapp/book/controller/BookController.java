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
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/getallbooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getbookbyauthor/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) throws BookException {
        return bookService.getBooksByAuthor(authorName);
    }

    @GetMapping("/getbookbytitle/{bookTitle}")
    public List<Book> getBooksByTitle(@PathVariable String bookTitle) throws BookException {
        return bookService.getBooksByTitle(bookTitle);
    }

}
