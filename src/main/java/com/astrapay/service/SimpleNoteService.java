package com.astrapay.service;

import com.astrapay.entity.SimpleNote;
import com.astrapay.exception.DuplicateNoteTitleException;
import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.dto.SimpleNoteDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SimpleNoteService {
    
    // store data in-memory
    private final List<SimpleNote> simpleNotes = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // get all notes
    public List<SimpleNote> getAllSimpleNotes(){
        return simpleNotes;
    }

    // add new note
    public SimpleNote createSimpleNote(SimpleNoteDto simpleNoteDto){

        // check if note title is already used
        boolean noteTitleExist = simpleNotes.stream().anyMatch(simpleNote -> simpleNote.getNoteTitle().equalsIgnoreCase(simpleNoteDto.getNoteTitle()));
        if (noteTitleExist){
            throw new DuplicateNoteTitleException("Note title is already used");
        }

        // increment counter for id
        SimpleNote simpleNote = new SimpleNote(counter.incrementAndGet(), simpleNoteDto.getNoteTitle(), simpleNoteDto.getNoteContent());

        simpleNotes.add(simpleNote);
        return simpleNote;
    }

    // delete a note
    public void deleteSimpleNote(Long noteId){

        // check if note exist
        boolean simpleNoteExist = simpleNotes.stream().anyMatch(simpleNote -> simpleNote.getNoteId().equals(noteId));
        if (!simpleNoteExist){
            throw new NoteNotFoundException("Note with ID " + noteId + " does not exist");
        }

        simpleNotes.removeIf(simpleNote -> simpleNote.getNoteId().equals(noteId));
    }

}
