package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDto;
import com.bridgelabz.bookstoreapp.exception.BookStoreException;
import com.bridgelabz.bookstoreapp.model.Book;
import com.bridgelabz.bookstoreapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * @return All books inside database with details
     */
    @GetMapping("/get-books")
    public List<Book> getBooks() {
        return bookService.getBookList();
    }

    /**
     * @param ids
     * @return Book details according to book id
     */
    @GetMapping("/get-books-by-id")
    public List<Book> getBookById(@RequestParam(value = "ids") Long[] ids) {
        return bookService.getBookById(ids);
    }

    /**
     * @param filter
     * @return Book by filter search may be it will be author name or book title
     * @throws BookStoreException
     */
    @GetMapping("/get-books/{filter}")
    public List<Book> getBookByFilter(@PathVariable String filter) throws BookStoreException {
        return bookService.getBookByFilter(filter);
    }

    /**
     * @param sort String Given By User
     * @return Book list by sorting price
     */
    @GetMapping("/sorted/{sort}")
    public List<Book> getBookBySort(@PathVariable(value = "sort") String sort) {
        return bookService.getBookBySort(sort);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
        Book book = bookService.addBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }
}
