package com.cache.manager.test.exception;


public class FileException extends RuntimeException{

    public FileException() {}


    public FileException(String message) {
        super(message);
    }

    public FileException(String message, String... values) {
        super(String.format(message, values));
    }

}
