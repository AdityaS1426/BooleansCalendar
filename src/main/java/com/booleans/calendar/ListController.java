package com.booleans.calendar;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparison;
import org.springframework.stereotype.Controller;
import com.booleans.calendar.FRQ.Neil.Inheritance;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ListController {

    @RequestMapping(value="/labs/Vihan/ListComparison", method={RequestMethod.GET,RequestMethod.GET})
    public String VihanList(@RequestParam(value="listElementType",required=false) String listElementType,@RequestParam(value="listlength", required=false,defaultValue="100") String listLength, Model model) {

        /* Required Steps from html to java
       1. Fill out list creation form

       2.  Submit form, send to <iframe> to send to control
       3.
       4.









         */



        if (listElementType != null) {
            int numOfInitialElements = Integer.parseInt(listLength);

            if (listElementType == "Computer") {
                ListComparison listcomparison = new ListComparison(Computer.class, numOfInitialElements );
            } else if (listElementType == "String") {
                ListComparison listcomparison = new ListComparison(String.class, numOfInitialElements );

            } else {//defaults to Integer list
                ListComparison listcomparison = new ListComparison(Integer.class, numOfInitialElements );
            }
        }






        return "labs/Vihan/ListComparison";
    }

}
