package com.dak.exceptions;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String message) {
        super(message);
    }
}
