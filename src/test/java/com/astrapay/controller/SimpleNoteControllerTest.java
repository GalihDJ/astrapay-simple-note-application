package com.astrapay.controller;

import com.astrapay.dto.SimpleNoteDto;
import com.astrapay.entity.SimpleNote;
import com.astrapay.service.SimpleNoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimpleNoteController.class)
class SimpleNoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SimpleNoteService simpleNoteService;

    @Autowired
    private ObjectMapper objectMapper;

    // private variable for API URL
    private static final String apiUrl = "/api/simple-note";

    // create a note with valid inputs
    @Test
    void createSimpleNote_withValidInputs_shouldBeSuccessful() throws Exception{

        // simulate input received in the request body
        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Valid Title", "Test Valid Content");
        // simulate output returned by the service
        SimpleNote simpleNote = new SimpleNote(1L, "Test Valid Title", "Test Valid Content");

        when(simpleNoteService.createSimpleNote(any(SimpleNoteDto.class)))
                .thenReturn(simpleNote);

        mockMvc.perform(post(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(simpleNoteDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.noteTitle").value("Test Valid Title"));
    }

    // create a note with blank title
    @Test
    void createSimpleNote_withBlankTitle_shouldReturnUnprocessableEntity() throws Exception{

        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("", "Test Valid Content");

        mockMvc.perform(post(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(simpleNoteDto)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.noteTitle").exists());
    }

    // create a note with blank content
    @Test
    void createSimpleNote_withBlankContent_shouldReturnUnprocessableEntity() throws Exception{

        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Valid Title", "");

        mockMvc.perform(post(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(simpleNoteDto)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.noteContent").exists());
    }

    // create a note with title more than 100 characters
    @Test
    void createSimpleNote_withVeryLongTitle_shouldReturn() throws Exception{

        // create very long title with more than 100 characters
        String longTitle = "a".repeat(101);
        SimpleNoteDto simpleNoteDto = new SimpleNoteDto(longTitle, "Test Valid Content");

        mockMvc.perform(post(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(simpleNoteDto)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.noteTitle").exists());
    }

    // create a note with content more than 1000 characters
    @Test
    void createSimpleNote_withVeryLongContent_shouldReturn() throws Exception{

        // create very long content with more than 1000 characters
        String longContent = "a".repeat(1001);
        SimpleNoteDto simpleNoteDto = new SimpleNoteDto("Test Valid Title", longContent);

        mockMvc.perform(post(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(simpleNoteDto)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.noteContent").exists());

    }
}