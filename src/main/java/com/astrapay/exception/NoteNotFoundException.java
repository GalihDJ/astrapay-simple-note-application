package com.astrapay.exception;

// custom exception if note not found
public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}