package org.example.module14.exceptions;

public class UnableDeleteNote extends RuntimeException {
    public UnableDeleteNote(String message) {
        super(message);
    }
}
