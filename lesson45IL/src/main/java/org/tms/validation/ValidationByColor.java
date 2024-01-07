package org.tms.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ColorValidation.class)
public @interface ValidationByColor {

    String message() default "This color is not allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}