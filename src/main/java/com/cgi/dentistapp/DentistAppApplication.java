package com.cgi.dentistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;

@SpringBootApplication
public class DentistAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(DentistAppApplication.class, args);

    }

    public static LinkedHashMap<Integer, String> getAvailableHours() {
        LinkedHashMap<Integer, String> hours = new LinkedHashMap<Integer, String>();

        for (int i = 9; i <= 16; i++) {
            hours.put(i, i + ":00");

        }
        return hours;
    }
    public static LinkedHashMap<Integer, String> getAvailableDays() {
        LinkedHashMap<Integer, String> days = new LinkedHashMap<Integer, String>();

        for (int i = 1; i <= 31; i++) {
            days.put(i, i + ".");
        }
        return days;
    }
    public static LinkedHashMap<Integer, String> getAvailableMonths() {
        LinkedHashMap<Integer, String> months = new LinkedHashMap<Integer, String>();

        months.put(1, "jaanuar");
        months.put(2, "veebruar");
        months.put(3, "märts");
        months.put(4, "aprill");
        months.put(5, "mai");
        months.put(6, "juuni");
        months.put(7, "juuli");
        months.put(8, "august");
        months.put(9, "september");
        months.put(10, "oktoober");
        months.put(11, "november");
        months.put(12, "detsember");

    return months;
    }
    public static LinkedHashMap<Integer, String> getAvailableYear() {
        LinkedHashMap<Integer, String> years = new LinkedHashMap<Integer, String>();

        years.put(2018, "2018");

      return years;
    }

}

