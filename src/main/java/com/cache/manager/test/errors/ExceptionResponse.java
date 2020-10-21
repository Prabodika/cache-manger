package com.cache.manager.test.errors;


import java.io.Serializable;

public class ExceptionResponse implements Serializable {

    private String errorMessage;



    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
