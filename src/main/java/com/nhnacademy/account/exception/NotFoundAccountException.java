package com.nhnacademy.account.exception;

public class NotFoundAccountException extends RuntimeException{
    public NotFoundAccountException(String message) {
        super(message);
    }
}
