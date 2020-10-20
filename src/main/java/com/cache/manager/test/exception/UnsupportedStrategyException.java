package com.cache.manager.test.exception;


public class UnsupportedStrategyException extends RuntimeException {

    public UnsupportedStrategyException() {}


    public UnsupportedStrategyException(String message) {
        super(message);
    }

    public UnsupportedStrategyException(String message, String... values) {
        super(String.format(message, values));
    }



}
