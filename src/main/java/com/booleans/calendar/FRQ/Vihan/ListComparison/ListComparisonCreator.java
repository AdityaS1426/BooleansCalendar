package com.booleans.calendar.FRQ.Vihan.ListComparison;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import org.springframework.stereotype.Service;

@Service
public class ListComparisonCreator {


    //create with string variable
    public static ListComparison generateListComparison(String listType, int listlength) {
        switch (listType) {
            case "String":
                return generateListComparison(String.class,listlength);

            case "Computer":
                return generateListComparison(Computer.class,listlength);

            default:
                return generateListComparison(Integer.class,listlength);
        }
    }

    public static ListComparison generateListComparison(Class listType, int listlength) {
            return new ListComparison(listType, listlength);
    }
}
