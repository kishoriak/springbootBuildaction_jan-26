package com.demo.exception;

public class TrainerNotFoundException extends RuntimeException{
    public TrainerNotFoundException(String msg) {
        super(msg);
    }

    public TrainerNotFoundException(int id) {
        super("trainer not found "+id);
    }
}
