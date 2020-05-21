package com.bridgelabz.bookstoreapp.book.service;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;
import com.bridgelabz.bookstoreapp.book.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBookByFilter(String filter) throws BookException {
        List<Book> bookSet = bookRepository.findBooksByBookAuthorContainsOrBookTitleContains(filter, filter);
        if (bookSet.isEmpty()) {
            throw new BookException(BookException.ExceptionType.BOOK_NOT_FOUND, "Book not found");
        }
        return bookSet;
    }
}
