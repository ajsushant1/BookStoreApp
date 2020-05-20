package com.bridgelabz.bookstoreapp.cart.exception;

public class CartException extends Throwable {
    ExceptionType type;

    public CartException(ExceptionType e, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        BOOK_NOT_FOUND;
    }
}
