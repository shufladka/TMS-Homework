package org.tms.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ColorValidation implements ConstraintValidator<ValidationByColor, String> {

    private List<String> blacklist = new ArrayList<>(List.of("red", "blue"));

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.isBlank()) {
            return false;
        }

        if (getBlacklist().contains(value)) {
            return false;
        }

        return true;
    }
}