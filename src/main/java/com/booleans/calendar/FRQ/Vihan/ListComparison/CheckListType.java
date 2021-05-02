package com.booleans.calendar.FRQ.Vihan.ListComparison;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;


@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckListTypeValidator.class)
@Documented

public @interface CheckListType {

    String message() default "{com.booleans.calendar.FRQ.Vihan.CheckListType}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

