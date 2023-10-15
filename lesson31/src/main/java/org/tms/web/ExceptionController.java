package org.tms.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tms.exception.ModelException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ModelException.class)
    public String modelError(ModelException numberException){
        System.out.println("ERROR: " + numberException.getCar().getModel() + " invalid model");
        return "error";
    }

    @ExceptionHandler(ModelException.class)
    public String conditionError(ModelException numberException){
        System.out.println("ERROR: " + numberException.getCar().getCondition() + " invalid condition");
        return "error";
    }

    @ExceptionHandler(ModelException.class)
    public String ageError(ModelException numberException){
        System.out.println("ERROR: " + numberException.getCar().getAge() + " invalid age");
        return "error";
    }
}