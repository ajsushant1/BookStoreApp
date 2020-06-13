package com.bridgelabz.bookstoreapp.user_details.exception;

public class UserRegistrationException extends Throwable {
    public ExceptionType type;

    public UserRegistrationException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        ALREADY_REGISTERED;
    }
}
