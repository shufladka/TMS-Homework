package org.tms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.tms.domain.Car;

@Data
@AllArgsConstructor
public class AgeException extends RuntimeException {
    private Car car;
}