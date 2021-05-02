package com.booleans.calendar;

import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.Sorting.Sorts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
                test = new Integer[]{5, 3, 33312, 82394, 367, 1, 327, 812};
            }
        } else if(arrayType.compareTo("Computer")==0) {

            test = new Computer[]{new Computer()};

            if (array.compareTo("default") == 0) {
                test = new Computer[]{new Computer(1000, "Comp1"), new Computer(512,"Comp1"), new Computer(128,"Comp2"), new Computer(256,"Comp3"), new Computer(2000,"Comp4"), new Computer(64,"Comp5")};
            }

        }
        ArrayList<Comparable> arr = new ArrayList<Comparable>(Arrays.asList(test));


        long start = 0;
        ArrayList<Comparable> sortedarray = new ArrayList<>();
        long elapsedTime = 0;

        if (sortMethod.compareTo("Insertion")==0) {
            start = System.nanoTime();
            sortedarray = (ArrayList) Sorts.insertionSort(arr);
            elapsedTime = System.nanoTime()-start;

        } else if (sortMethod.compareTo("Selection")==0) {
            start = System.nanoTime();
            sortedarray = (ArrayList) Sorts.selectionSort(arr);
            elapsedTime = System.nanoTime()-start;
        } else if (sortMethod.compareTo("Bubble")==0) {
            //Bubble Sort
            start = System.nanoTime();
            sortedarray =  (ArrayList) Sorts.bubbleSort(arr);
            elapsedTime = System.nanoTime()-start;
        }


        model.addAttribute("elapsedTime", String.valueOf(elapsedTime));
        model.addAttribute("array",new ArrayList<Comparable>(Arrays.asList(test)).toString());
        model.addAttribute("sortedarray",sortedarray.toString());


        return "labs/Vihan/Sorts";
    }
}
