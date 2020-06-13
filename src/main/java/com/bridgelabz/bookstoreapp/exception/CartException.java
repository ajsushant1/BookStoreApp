package com.bridgelabz.bookstoreapp.exception;

public class CartException extends Throwable {
    ExceptionType type;

    public CartException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        BOOK_NOT_FOUND;
    }
}
