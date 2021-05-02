package com.booleans.calendar;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.Sorting.Sorts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Arrays;


@Controller
public class SortController {

    @RequestMapping(value = "/labs/Vihan/Sorts", method = {RequestMethod.GET, RequestMethod.POST})
    public String VihanSort(@RequestParam(value = "array", required = false, defaultValue = "default") String array, @RequestParam(value="arrayType", required = false, defaultValue="Integer") String arrayType, @RequestParam(value="sortMethod", required = false, defaultValue="Bubble") String sortMethod,Model model) {

        Comparable[] test = new Comparable[]{};
        Sorts sort = new Sorts();
        if(arrayType.compareTo("String")==0) {
            test = new String[]{""};

            if (array.compareTo("default") == 0) {
                test = new String[]{"dasfa", "akf;lk", "aaaaaaaa", "aa", "yldfjwo"};
            }

        } else if (arrayType.compareTo("Integer")==0) {

            test = new Integer[]{0};

            if (array.compareTo("default") == 0) {
                test = new Integer[]{75, 67, 596, 777, 913021, 1, 4507, 81236};
            }
        } else if(arrayType.compareTo("Computer")==0) {

            test = new Computer[]{new Computer()};

            if (array.compareTo("default") == 0) {
                test = new Computer[]{new Computer(1000, "Comp1"), new Computer(512,"Comp1"), new Computer(128,"Comp2"), new Computer(256,"Comp3"), new Computer(2000,"Comp4"), new Computer(64,"Comp5")};
            }

        }
        sort = new Sorts(new ArrayList<Comparable>(Arrays.asList(test)),sortMethod);
        model.addAttribute("elapsedTime", String.valueOf(sort.elapsedTime));
        model.addAttribute("array",sort.array.toString());
        model.addAttribute("sortedarray",sort.sortedarray.toString());


        return "labs/Vihan/Sorts";
    }
    @RequestMapping(value = "/labs/Neil/Sorts", method = {RequestMethod.GET, RequestMethod.POST})
    public String NeilSort(@RequestParam(value = "array", required = false, defaultValue = "default") String array, @RequestParam(value="arrayType", required = false, defaultValue="Integer") String arrayType, @RequestParam(value="sortMethod", required = false, defaultValue="Bubble") String sortMethod,Model model) {

        Comparable[] test = new Comparable[]{};
        Sorts sort = new Sorts();
        if(arrayType.compareTo("String")==0) {
            test = new String[]{""};

            if (array.compareTo("default") == 0) {
                test = new String[]{"HI", "HELLO", "GOOD MORNING", "LOL", "GOOD"};
            }

        } else if (arrayType.compareTo("Integer")==0) {

            test = new Integer[]{0};

            if (array.compareTo("default") == 0) {
                test = new Integer[]{75, 67, 596, 777, 913021, 1, 4507, 81236};
            }
        } else if(arrayType.compareTo("Computer")==0) {

            test = new Computer[]{new Computer()};

        }
        sort = new Sorts(new ArrayList<Comparable>(Arrays.asList(test)),sortMethod);
        model.addAttribute("elapsedTime", String.valueOf(sort.elapsedTime));
        model.addAttribute("array",sort.array.toString());
        model.addAttribute("sortedarray",sort.sortedarray.toString());


        return "labs/Neil/NeilSorts";
    }
}
