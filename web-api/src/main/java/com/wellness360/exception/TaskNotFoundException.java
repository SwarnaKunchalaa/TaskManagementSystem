package com.wellness360.exception;

public class TaskNotFoundException
        extends RuntimeException {

    public TaskNotFoundException(String message) {
        super(message);
    }
}