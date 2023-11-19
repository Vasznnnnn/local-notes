package com.apps.notes.service;


import com.apps.notes.exception.NoteException;
import com.apps.notes.logger.Logger;
import com.apps.notes.model.Note;
import com.apps.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    private static final String INVALID_NOTE ="Invalid Note being created";

    public boolean createNote(Note note) {
        String noteData = note.getNoteData();
        try{
            if(!noteData.isEmpty() & !note.getNoteTopic().isEmpty()){
                note.setId(UUID.randomUUID().toString());
                noteRepository.save(note);
                Logger.info("New Note is being created");
                return true;
            }
        } catch (NoteException exception) {
            Logger.error("Invalid and Empty Note");
            throw new NoteException(INVALID_NOTE,exception);
        }
        return false;
    };

    public boolean editNote(String id, Note note) {
        String noteData = note.getNoteData();
        String topic = note.getNoteTopic();
        Date modifiedTime = note.getNoteModifiedTime();
        String modifiedBy = note.getNoteModifiedBy();
        try{
            if(!noteData.isEmpty() & !note.getNoteTopic().isEmpty()){
                noteRepository.updateNote(id,noteData,topic,modifiedTime,modifiedBy);
                Logger.info("New Note is being created");
                return true;
            }
        } catch (NoteException exception) {
            Logger.error("Invalid and Empty Note");
            throw new NoteException(INVALID_NOTE,exception);
        }
        return false;
    };

    public boolean deleteNote(String id) {
        try{
            if(id!=null){
                noteRepository.deleteById(id);
                Logger.info("Note is being deleted");
                return true;
            }
        } catch (NoteException err) {
            throw new NoteException(err);
        }
        return false;
    };

    public Note viewNote(String id) {
        try{
            if(id!=null){
                Note note = noteRepository.getById(id);
                Logger.info("Note is retrieved");
                return note;
            }
        } catch (NoteException err) {
            throw new NoteException(err);
        }
        return null;
    }


}
