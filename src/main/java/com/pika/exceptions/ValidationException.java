package com.pika.exceptions;

/**
 * Created by LU355846 on 9/16/2016.
 */
public class ValidationException extends Exception {
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
