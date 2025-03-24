package com.astrapay.exception;

// custom exception for invalid note (empty title and description)
public class InvalidNoteException extends RuntimeException{
    public InvalidNoteException(String message) {
        super(message);
    }
}
