package com.astrapay.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleNoteDto {

    // variables with validation annotations
    @NotBlank(message = "Note title cannot be blank")
    @Size(max = 100, message = "Note title cannot exceed 100 characters")
    private String noteTitle;

    @NotBlank(message = "Note content cannot be blank")
    @Size(max = 1000, message = "Note content cannot exceed 1000 characters")
    private String noteContent;

    // constructor
    public SimpleNoteDto(String noteTitle, String noteContent){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    // getter and setter
    public String getNoteTitle(){
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent(){
        return noteContent;
    }

    public void setNoteContent(String noteContent){
        this.noteContent = noteContent;
    }
}
