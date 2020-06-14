package com.bridgelabz.bookstoreapp.book.service;

import com.bridgelabz.bookstoreapp.book.exception.BookException;
import com.bridgelabz.bookstoreapp.book.model.Book;
import com.bridgelabz.bookstoreapp.book.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    final
    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByFilter(String filter) throws BookException {
        //Using custom method to filter by search string
        List<Book> bookList = bookRepository.findBooksByBookAuthorContainsOrBookTitleContains(filter, filter);
        if (bookList.isEmpty()) {
            throw new BookException(BookException.ExceptionType.BOOK_NOT_FOUND, "Book not found");
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksBySort(String sort) {
        List<Book> bookList = null;
        switch (sort) {
            case "increasing":
                bookList = bookRepository.findByOrderByBookPrice();
                break;
            case "decreasing":
                bookList = bookRepository.findByOrderByBookPriceDesc();
                break;
            default:
                bookList = bookRepository.findByOrderByBookQuantity();
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksByIdIn(Long[] ids) {
        return bookRepository.findAllById(Arrays.asList(ids));
    }
}
