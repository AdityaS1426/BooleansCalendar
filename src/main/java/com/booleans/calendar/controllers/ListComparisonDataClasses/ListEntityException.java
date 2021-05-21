package com.booleans.calendar.controllers.ListComparisonDataClasses;

public class ListEntityException extends RuntimeException {

    ListEntityException(Long id) {
        super("Could not find list:" + id);

    }
}


