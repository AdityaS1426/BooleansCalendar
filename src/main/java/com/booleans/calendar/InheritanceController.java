package com.booleans.calendar;

import org.springframework.stereotype.Controller;
import com.booleans.calendar.FRQ.Neil.Inheritance;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.booleans.calendar.FRQ.Vihan.Inheritance.*;


@Controller
public class InheritanceController {


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
            Computer computer = new Laptop(stor,name,ra,o, battery);
            model.addAttribute("computerToString",computer.toString());

        } else {
            Computer computer = new Computer(stor,name,ra,o);
            model.addAttribute("computerToString",computer.toString());
        }


        return "labs/Vihan/Inheritance";
    }

}
