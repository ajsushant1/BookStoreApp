package com.bridgelabz.bookstoreapp.book.controller;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;
import com.bridgelabz.bookstoreapp.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    final
    IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get-books-by-id")
    public List<Book> getBooksByIdIn(@RequestParam(value = "ids") Long[] ids) {
        return bookService.getBooksByIdIn(ids);
    }

    @GetMapping("/get-books/{filter}")
    public List<Book> getBooksByFilter(@PathVariable String filter) throws BookException {
        return bookService.getBooksByFilter(filter);
    }
}
