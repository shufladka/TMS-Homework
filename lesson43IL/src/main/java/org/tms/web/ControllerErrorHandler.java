package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tms.lesson43il.exceptions.CarFailedException;
import org.tms.lesson43il.exceptions.ErrorDetailsException;
import org.tms.lesson43il.mapper.ErrorMapper;

@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerErrorHandler {

    private final ErrorMapper mapper;

    @ExceptionHandler(CarFailedException.class)
    public ResponseEntity<ErrorDetailsException> handler(CarFailedException exc) {

        return ResponseEntity.status(exc.getCode())
                .body(mapper.toIl(exc));
    }
}