package com.bridgelabz.bookstoreapp.exception;

public class UserException extends Throwable {
    public ExceptionType type;

    public UserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        ALREADY_REGISTERED, NOT_FOUND
    }
}
