package com.astrapay.controller;

import com.astrapay.entity.SimpleNote;
import com.astrapay.dto.SimpleNoteDto;
import com.astrapay.service.SimpleNoteService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/simple-note")
@Api(value = "SimpleNoteController")
@Slf4j

public class SimpleNoteController {
    
    @Autowired
    private SimpleNoteService simpleNoteService;


    // get all notes
    @GetMapping
    public ResponseEntity<List<SimpleNote>> getAllSimpleNotes(){
        return ResponseEntity.ok(simpleNoteService.getAllSimpleNotes());
    }

    // create a new note
    @PostMapping
    public ResponseEntity<SimpleNote> createSimpleNote(@RequestBody @Valid SimpleNoteDto simpleNoteDto){

        SimpleNote simpleNote = simpleNoteService.createSimpleNote(simpleNoteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(simpleNote);
    }

    // delete a note by id
    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteSimpleNote(@PathVariable Long noteId){

        simpleNoteService.deleteSimpleNote(noteId);
        return ResponseEntity.noContent().build();
    }

}
