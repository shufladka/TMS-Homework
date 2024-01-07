package org.tms.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarFailedException extends RuntimeException {

    @JsonProperty("message")
    private final String errorMessage;
    private final String service;
    private final Integer code;

    public CarFailedException(String errorMessage, String service, Integer code) {
        this.errorMessage = errorMessage;
        this.service = service;
        this.code = code;
    }
}