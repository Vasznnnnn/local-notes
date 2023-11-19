package com.apps.notes.controller;

import com.apps.notes.exception.NoteException;
import com.apps.notes.logger.Logger;
import com.apps.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apps.notes.service.NoteService;


@RestController
@RequestMapping(value = "/Note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "/viewNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> viewNote(@RequestParam(name="id")String id) {
        try{
            Logger.info("Succesfully fetched Note"+ id);
            return new ResponseEntity<Note>(noteService.viewNote(id), HttpStatus.OK);
        } catch (NoteException exception) {
            Logger.error(exception.getMessage().toString());
            throw new NoteException("Failed to get Note"+id);
        }

    }

    @PostMapping(value = "/createNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createNote(@RequestBody Note note) {
        try{
            Logger.info("Succesfully Created a Note"+ note.getId());
            return new ResponseEntity<Boolean>(noteService.createNote(note), HttpStatus.OK);
        } catch (NoteException exception) {
            Logger.error(exception.getMessage().toString());
            throw new NoteException("Failed to Create Note"+note.getId());
        }

    }

    @PutMapping(value = "/editNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editNote(@RequestParam(name = "id")String id, Note note) throws NoteException {
        try{
            Logger.info("Succesfully edited Note" +id);
            return new ResponseEntity<Boolean>(noteService.editNote(id,note), HttpStatus.OK);
        } catch (NoteException exception) {
            Logger.error(exception.getMessage().toString());
            throw new NoteException("Failed to Edit Note"+id);
        }
    }

    @DeleteMapping(value = "/deleteNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteNote(@RequestParam(name = "id")String id) {
        try{
            Logger.info("Succesfully deleted Note"+id);
            return new ResponseEntity<Boolean>(noteService.deleteNote(id), HttpStatus.OK);
        } catch (NoteException exception) {
            Logger.error(exception.getMessage().toString());
            throw new NoteException("Failed to delete Note"+id);
        }
    }

}
