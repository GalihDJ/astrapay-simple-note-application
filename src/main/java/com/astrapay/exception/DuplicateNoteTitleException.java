package com.astrapay.exception;

// custom exception for duplicate note title
public class DuplicateNoteTitleException extends RuntimeException {
    public DuplicateNoteTitleException(String message) {
        super(message);
    }
}
