package com.bridgelabz.bookstoreapp.book.controller;

import com.bridgelabz.bookstoreapp.book.model.Book;
import com.bridgelabz.bookstoreapp.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
