package org.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tms.enums.Trademark;
import org.tms.validation.ValidationByColor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Integer id;
    private Trademark trademark;

    @ValidationByColor
    private String color;
}