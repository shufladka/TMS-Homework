package org.tms.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tms.lesson43bl.exceptions.CarFailedException;
import org.tms.lesson43bl.exceptions.ErrorDetailsException;

@RestControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(CarFailedException.class)
    public ResponseEntity<ErrorDetailsException> handler(CarFailedException exc) {

        String errorMessage = exc.getErrorMessage();

        ErrorDetailsException errorDetails = ErrorDetailsException.builder()
                .service("car-client")
                .message(errorMessage)
                .code(400)
                .build();

        return ResponseEntity.status(400)
                .body(errorDetails);
    }
}