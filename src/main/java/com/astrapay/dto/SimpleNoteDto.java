package com.astrapay.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleNoteDto {

    @NotBlank(message = "Note title cannot be blank")
    private String noteTitle;

    @NotBlank(message = "Note content cannot be blank")
    private String noteContent;

    public SimpleNoteDto(String noteTitle, String noteContent){
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

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
