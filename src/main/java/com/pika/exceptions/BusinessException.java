package com.pika.exceptions;

/**
 * Created by LU355846 on 9/16/2016.
 */
public class BusinessException extends Exception {
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
