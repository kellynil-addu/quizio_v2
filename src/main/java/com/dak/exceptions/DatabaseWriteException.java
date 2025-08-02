package com.dak.exceptions;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String message) {
        super(message);
    }
}
