package com.booleans.calendar.FRQ.Vihan.ListComparison;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckListTypeValidator implements ConstraintValidator<CheckListType, String> {


    public void initialize(CheckListType constraintAnnotation) {
    }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        if (object == null)
            return true;


        boolean isValid;
        isValid = new ArrayList(Arrays.asList("Computer", "Integer", "String")).contains(object);


        if (!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("{com.booleans.calendar.FRQ.Vihan.CheckListType.message}").addConstraintViolation();
        }
        return isValid;

    }

}
