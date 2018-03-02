package com.exception;

public class BookAlreadyExistException extends Exception {

    public BookAlreadyExistException(String message){
        super(message);
    }
}