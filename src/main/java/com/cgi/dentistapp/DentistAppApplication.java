package com.cgi.dentistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;
import java.util.Locale;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);

    }

    public static LinkedHashMap<Integer, String> getAvailableHours() {
        LinkedHashMap<Integer, String> hours = new LinkedHashMap<Integer, String>();

        hours.put(9, "9:00");
        hours.put(10, "10:00");
        hours.put(11, "11:00");
        hours.put(12, "12:00");
        hours.put(13, "13:00");
        hours.put(14, "14:00");
        hours.put(15, "15:00");
        hours.put(16, "16:00");

        return hours;
    }

}
