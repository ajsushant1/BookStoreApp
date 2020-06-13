package com.bridgelabz.bookstoreapp.exception;

public class BookException extends Exception {

    ExceptionType type;

    public BookException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        BOOK_NOT_FOUND;
    }
}
