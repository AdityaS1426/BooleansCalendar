package com.booleans.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class CalendarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //Starting up Spring Application
        SpringApplication.run(CalendarApplication.class, args);
    }
}
