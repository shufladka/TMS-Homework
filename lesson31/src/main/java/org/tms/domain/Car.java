package org.tms.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private String condition;
    private Integer age;
}