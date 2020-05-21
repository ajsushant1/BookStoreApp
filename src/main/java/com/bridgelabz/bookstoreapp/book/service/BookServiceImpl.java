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
    public List<Book> getBooksByAuthor(String authorName) throws BookException {
        List<Book> booksListByBookAuthor = bookRepository.findBooksByBookAuthor(authorName);
        if (booksListByBookAuthor.isEmpty()) {
            throw new BookException(BookException.ExceptionType.BOOK_NOT_FOUND, "Book not found");
        }
        return booksListByBookAuthor;
    }

    @Override
    public List<Book> getBooksByTitle(String bookTitle) throws BookException {
        List<Book> booksListByBookTitle = bookRepository.findBooksByBookTitle(bookTitle);
        if (booksListByBookTitle.isEmpty()) {
            throw new BookException(BookException.ExceptionType.BOOK_NOT_FOUND, "Book not found");
        }
        return booksListByBookTitle;
    }
}
