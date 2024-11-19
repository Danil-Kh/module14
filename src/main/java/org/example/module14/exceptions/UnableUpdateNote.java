package org.example.module14.exceptions;

public class UnableUpdateNote extends RuntimeException {
    public UnableUpdateNote(String message)
    {
        super(message);
    }
}
