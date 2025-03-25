package com.astrapay.service;

import com.astrapay.dto.SimpleNoteDto;
import com.astrapay.entity.SimpleNote;
import com.astrapay.exception.DuplicateNoteTitleException;
import com.astrapay.exception.NoteNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleNoteServiceTest {

    private SimpleNoteService simpleNoteService;

    @BeforeEach
    void setUp() {
        simpleNoteService = new SimpleNoteService();
    }

    // get all notes (should be empty at first)
    @Test
    void getAllNotes_initiallyReturnsEmpty(){

        List<SimpleNote> result = simpleNoteService.getAllSimpleNotes();
        assertTrue(result.isEmpty());
    }

    // create a note - success
    @Test
    void createASimpleNote_withValidInputs_shouldBeSuccessful(){

        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Title", "Test Content");
        SimpleNote result = simpleNoteService.createSimpleNote(simpleNoteDto);
        assertEquals("Test Title", result.getNoteTitle());
        assertEquals("Test Content", result.getNoteContent());
        assertNotNull(result);
    }

    // get all notes after successfully creating one
    @Test
    void createASimpleNote_withValidInput_getNoteAfterCreate_shouldBeSuccessful(){

        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Title", "Test Content");
        simpleNoteService.createSimpleNote(simpleNoteDto);

        List<SimpleNote> result = simpleNoteService.getAllSimpleNotes();
        assertNotNull(result);
    }

    // create a note with duplicate title
    @Test
    void createASimpleNote_withDuplicateTitle_shouldFail(){

        SimpleNoteDto firstNote = new SimpleNoteDto("Test Title Duplicate", "First Content");
        SimpleNoteDto secondNote = new SimpleNoteDto("Test Title Duplicate", "Second Content");
        simpleNoteService.createSimpleNote(firstNote);

        assertThrows(DuplicateNoteTitleException.class, () -> {
            simpleNoteService.createSimpleNote(secondNote);
        });
    }

    // delete a note
    @Test
    void deleteASimpleNote_withExistingId_shouldDeleteNoteSuccessfully(){

        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Title Delete", "Test Content Delete");
        SimpleNote newSimpleNote = simpleNoteService.createSimpleNote(simpleNoteDto);

        simpleNoteService.deleteSimpleNote(newSimpleNote.getNoteId());

        assertTrue(simpleNoteService.getAllSimpleNotes().isEmpty());
    }

    // delete a note with non-existing id
    @Test
    void deleteASimpleNote_withNonExistingId_shouldFail(){
        assertThrows(NoteNotFoundException.class, () -> {
            simpleNoteService.deleteSimpleNote(100L);
        });
    }
}