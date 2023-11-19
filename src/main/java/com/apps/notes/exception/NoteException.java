package com.apps.notes.exception;

public class NoteException extends RuntimeException {

    public NoteException() {
        super();
    };

    public NoteException(String message){
        super(message);
    };

    public NoteException(String message, Throwable cause){
        super(message,cause);
    };

    public NoteException(Throwable cause) {
        super(cause);
    };
}
