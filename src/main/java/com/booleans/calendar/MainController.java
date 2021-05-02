package com.booleans.calendar;


import com.booleans.calendar.FRQ.Neil.Inheritance;
import com.booleans.calendar.FRQ.Vihan.Inheritance.Computer;
import com.booleans.calendar.FRQ.Vihan.Inheritance.Laptop;
import com.booleans.calendar.FRQ.Yasaswi.LinkedList;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.booleans.calendar.FRQ.Praveen.CarInheritance;
import com.booleans.calendar.FRQ.Praveen.RecursionPraveen;
import com.booleans.calendar.FRQ.Neil.RecursionNeil;
import com.booleans.calendar.FRQ.Vihan.Recursion.FrogRiver;


@Controller
public class MainController extends SpringBootServletInitializer {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String Index() {
        return "Index";
    }

    @GetMapping("/labs")
    public String MiniLabs() { return "MiniLabsHome"; }

    @GetMapping("/BooleansCalendar")
    public String BooleansCalendar() {return "Calendar";}

    @GetMapping("/calculator")
    public String Calculator() {return "LabsHTMLPages/Aditya/AdityaRecursionCalculator";}

    /*@GetMapping("/labs/Vihan/river")
    public String river() {return "/LabsHTMLPages/Vihan/RiverRecursion";}*/

    @RequestMapping(value = "/labs/Vihan/RiverRecursion", method = {RequestMethod.GET, RequestMethod.POST})
    public String PostRiver(@RequestParam(value = "rocks", required = false, defaultValue = "3") String rocks, Model model) {

        int numrocks = Integer.parseInt(rocks);
        FrogRiver river = new FrogRiver(numrocks);

        model.addAttribute("paths", String.valueOf(river.getPaths()));
        model.addAttribute("riverTime", String.valueOf(river.getTimeElapsed()));

        return "labs/Vihan/RiverRecursion";
    }

    @RequestMapping(value = "/labs/Praveen/dafact", method = {RequestMethod.GET, RequestMethod.POST})
    public String Factorial(@RequestParam(value = "totfact", required = false, defaultValue = "3") String totfact, Model model) {

        RecursionPraveen factorial = new RecursionPraveen();
        int factnum = Integer.parseInt(totfact);

        model.addAttribute("paths", factorial.fact(factnum));
        model.addAttribute("facttime", String.valueOf(factorial.getTimeElapsed()));


        return "labs/Praveen/praveenFactorial";
    }

    @RequestMapping(value = "/labs/Neil/dafact", method = {RequestMethod.GET, RequestMethod.POST})
    public String FactorialNeil(@RequestParam(value = "totfact", required = false, defaultValue = "1") String totfact, Model model) {

        RecursionNeil factorial = new RecursionNeil();
        int factnum = Integer.parseInt(totfact);

        model.addAttribute("paths", factorial.fact(factnum));
        model.addAttribute("paths", factorial.loop(factnum));


        return "labs/Neil/NeilFactorial";
    }
/*
    @RequestMapping("/labs/Vihan/Inheritance")
    public String VihanInheritance(@RequestParam(value = "computerType", required=false, defaultValue="Computer") String computerType,@RequestParam(value = "storage", required=false, defaultValue="256") String storage, @RequestParam(value = "ram", required=false, defaultValue="8") String ram,@RequestParam(value = "name", required=false, defaultValue="Computer") String name,@RequestParam(value = "operatingsystem", required=false, defaultValue="Ubuntu") String operatingsystem,@RequestParam(value = "batteryduration", required=false, defaultValue="8") String batteryduration,Model model) {
        System.out.println(computerType);
        int stor = Integer.parseInt(storage);
        int ra = Integer.parseInt(ram);
        int battery = Integer.parseInt(batteryduration);
        Computer.OperatingSystem o;
        if (operatingsystem.compareTo("Windows")==0) {
            o = Computer.OperatingSystem.WINDOWS;
        } else if (operatingsystem.compareTo("MacOS")==0) {
            o = Computer.OperatingSystem.MACOS;
        } else {
            o = Computer.OperatingSystem.UBUNTU;
        }
        if (computerType.compareTo("Laptop")==0) {
            Laptop computer = new Laptop(stor,name,ra,o, battery);
            model.addAttribute("computerToString",computer.toString());
        } else {
            Computer computer = new Computer(stor,name,ra,o);
            model.addAttribute("computerToString",computer.toString());
        }
        return "labs/Vihan/Inheritance";
    }
*/
    @RequestMapping(value = "/labs/Neil/inheritance", method = {RequestMethod.GET, RequestMethod.POST})
    public String Food(@RequestParam(value = "name", required = false, defaultValue = "3") String name, @RequestParam(value = "cost", required = false, defaultValue = "3") String cost, @RequestParam(value = "calories", required = false, defaultValue = "3") String calories, Model model) {

        Inheritance food = new Inheritance();
        int Daname = Integer.parseInt(name);
        int DaSpeed = Integer.parseInt(cost);
        int DaHeight = Integer.parseInt(calories);

        model.addAttribute("paths", food);

        return "labs/Neil/NeilInheritance";
    }

       @RequestMapping(value = "/labs/Yasaswi/LinkedList", method = {RequestMethod.GET, RequestMethod.POST})
    public String LinkedList(@RequestParam(value = "add", required = false, defaultValue = "7") String add, Model model) {

        LinkedList list = new LinkedList(new int[]{9, 1, 8, 5, 2, 3});

        int val = Integer.parseInt(add);

        list.addHead(val);

        model.addAttribute("linkedlist1", list.traverse().get(0));
        model.addAttribute("linkedlist2", list.traverse().get(1));
        model.addAttribute("linkedlist3", list.traverse().get(list.traverse().size()-1));
        model.addAttribute("linkedlist4", list.traverse());

        return "labs/Yasaswi/YasaswiLinkedList";
    }

    @RequestMapping(value = "/labs/Praveen/LinkedList", method = {RequestMethod.GET, RequestMethod.POST})
    public String LinkedListPraveen(@RequestParam(value = "add", required = false, defaultValue = "7") String add, Model model) {

        LinkedList list = new LinkedList(new int[]{1, 2, 3, 4});

        int val = Integer.parseInt(add);

        list.addHead(val);

        model.addAttribute("linkedlist1", list.traverse().get(0));
        model.addAttribute("linkedlist2", list.traverse().get(1));
        model.addAttribute("linkedlist3", list.traverse().get(list.traverse().size()-1));
        model.addAttribute("linkedlist4", list.traverse());

        return "labs/Praveen/PraveenLinkedList";
    }

    @RequestMapping(value = "/labs/Neil/LinkedList", method = {RequestMethod.GET, RequestMethod.POST})
    public String LinkedListNeil(@RequestParam(value = "add", required = false, defaultValue = "12") String add, Model model) {

        LinkedList list = new LinkedList(new int[]{7,6,2,5,4,8});

        int val = Integer.parseInt(add);

        list.addHead(val);

        model.addAttribute("linkedlist1", list.traverse().get(0));
        model.addAttribute("linkedlist2", list.traverse().get(1));
        model.addAttribute("linkedlist3", list.traverse().get(list.traverse().size()-1));
        model.addAttribute("linkedlist4", list.traverse());

        return "labs/Neil/NeilLinkedList";
    }
}
