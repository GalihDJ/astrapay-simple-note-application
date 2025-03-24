package com.astrapay.entity;

public class SimpleNote {

    private long noteId;
    private String noteTitle;
    private String noteContent;

    public SimpleNote(long noteId, String noteTitle, String noteContent){
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public Long getNoteId(){
        return noteId;
    }

    public void setNoteId(Long noteId){
        this.noteId = noteId;
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
