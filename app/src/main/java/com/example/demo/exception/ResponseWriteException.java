package com.example.demo.exception;

public class ResponseWriteException extends RuntimeException {

    public ResponseWriteException(String message) {
       super(message);
    }
}
