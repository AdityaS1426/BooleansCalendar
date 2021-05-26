package com.booleans.calendar.controllers.ListComparisonDataClasses;

import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparison;
import com.booleans.calendar.FRQ.Vihan.ListComparison.ListComparisonCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ListController {

    ListComparisonCreator listComparisonCreator;
    ListComparison listComparison;



    @GetMapping("/labs/Vihan/ListComparison")
    public String listComparison() {
        return "/labs/Vihan/ListComparison.html";
    }


}





