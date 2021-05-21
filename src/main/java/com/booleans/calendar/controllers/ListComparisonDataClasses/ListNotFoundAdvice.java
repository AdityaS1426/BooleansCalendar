package com.booleans.calendar.controllers.ListComparisonDataClasses;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;




@ControllerAdvice
public class ListNotFoundAdvice {

        @ResponseBody
        @ExceptionHandler(ListEntityException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String listNotFoundHandler(ListEntityException ex) {
            return ex.getMessage();
        }
}
