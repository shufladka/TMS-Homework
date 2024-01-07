package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tms.exceptions.CarFailedException;
import org.tms.exceptions.IlError;
import org.tms.mapper.ErrorMapper;

@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerErrorHandler {

    private final ErrorMapper mapper;

    @ExceptionHandler(CarFailedException.class)
    public ResponseEntity<IlError> handler(CarFailedException exc) {

        return ResponseEntity.status(exc.getCode())
                .body(mapper.toIl(exc));
    }
}