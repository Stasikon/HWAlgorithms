package com.example.main.Example;

public class ValueCanNotBeEmptyException extends IllegalArgumentException {
    ValueCanNotBeEmptyException() {
    }
    public ValueCanNotBeEmptyException(String s) {
        super(s);
    }

    public ValueCanNotBeEmptyException(String message, Throwable cause) {
        super(message,cause);
    }
}
