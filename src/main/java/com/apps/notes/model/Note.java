package com.apps.notes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name="NOTE")
public class Note {

    @Id
    private String id;

    @Column("NOTE_TOPIC")
    @JsonProperty("noteTopic")
    private String noteTopic;

    @Column("NOTE_DATA")
    @JsonProperty("noteData")
    private String noteData;

    @Column("NOTE_CREATED_TIME")
    @JsonProperty("noteCreatedTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date noteCreatedTime;

    @Column("NOTE_MODIFIED_TIME")
    @JsonProperty("noteModifiedTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date noteModifiedTime;


    @Column("NOTE_MODIFIED_BY")
    @JsonProperty("noteModifiedBy")
    private String noteModifiedBy;

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNoteTopic() {
        return noteTopic;
    }

    public void setNoteTopic(String noteTopic) {
        this.noteTopic = noteTopic;
    }

    public String getNoteData() {
        return noteData;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    public Date getNoteCreatedTime() {
        return noteCreatedTime;
    }

    public void setNoteCreatedTime(Date noteCreatedTime) {
        this.noteCreatedTime = noteCreatedTime;
    }

    public Date getNoteModifiedTime() {
        return noteModifiedTime;
    }

    public void setNoteModifiedTime(Date noteModifiedTime) {
        this.noteModifiedTime = noteModifiedTime;
    }

    public String getNoteModifiedBy() {
        return noteModifiedBy;
    }

    public void setNoteModifiedBy(String noteModifiedBy) {
        this.noteModifiedBy = noteModifiedBy;
    }

    public Note() {
    }

    public Note(String id, String noteTopic, String noteData, Date noteCreatedTime, Date noteModifiedTime, String noteModifiedBy) {
        this.id = id;
        this.noteTopic = noteTopic;
        this.noteData = noteData;
        this.noteCreatedTime = noteCreatedTime;
        this.noteModifiedTime = noteModifiedTime;
        this.noteModifiedBy = noteModifiedBy;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", noteTopic='" + noteTopic + '\'' +
                ", noteData='" + noteData + '\'' +
                ", noteCreatedTime=" + noteCreatedTime +
                ", noteModifiedTime=" + noteModifiedTime +
                ", noteModifiedBy='" + noteModifiedBy + '\'' +
                '}';
    }
}
