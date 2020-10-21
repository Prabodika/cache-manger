package com.cache.manager.test.controller;

import com.cache.manager.test.errors.ExceptionResponse;
import com.cache.manager.test.exception.*;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CacheControllerAdviser {


    @ExceptionHandler(FileException.class)
    public ResponseEntity<Object> fileException(
            FileException ex) {

        ExceptionResponse body = new ExceptionResponse();
        body.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> dataNotFound(
            NotFoundException ex) {

        ExceptionResponse body = new ExceptionResponse();
        body.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnsupportedStrategyException.class)
    public ResponseEntity<Object> unsupportedStrategyException(
            UnsupportedStrategyException ex) {

        ExceptionResponse body = new ExceptionResponse();
        body.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> InternalServerError(
            Exception ex) {

        ExceptionResponse body = new ExceptionResponse();
        body.setErrorMessage("Internal server error");

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
