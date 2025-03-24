package com.astrapay.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.exception.DuplicateNoteTitleException;
import com.astrapay.exception.InvalidNoteException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handleNoteNotFoundException(NoteNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidNoteException.class)
    public ResponseEntity<String> handleInvalidNoteException(InvalidNoteException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicateNoteTitleException.class)
    public ResponseEntity<String> handleDuplicateNoteTitleException(DuplicateNoteTitleException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return new ResponseEntity<>("An unexpected error occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}