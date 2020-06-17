package com.bridgelabz.bookstoreapp.exception;

public class BookStoreException extends Exception {

    public ExceptionType type;

    public BookStoreException(ExceptionType Type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        BOOK_IS_NOT_AVAILABLE
    }
}
