package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.Dentist;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO) {

        return "form";
    }

    @PostMapping("/")

    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        String dentistId = dentistVisitDTO.getSelectedDentist();
        Dentist dentist = dentistVisitService.getDentistByID(dentistId);
        String dentistName = "";

        if (dentist != null) {
            dentistName = dentist.getName();
        } else {
            throw new RuntimeException("Doctor not found!");
        }

        Date visitDate = dentistVisitDTO.getVisitTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(visitDate);
        calendar.set(Calendar.HOUR_OF_DAY, dentistVisitDTO.getSelectedHour());
        calendar.set(Calendar.DAY_OF_MONTH, dentistVisitDTO.getSelectedDay());
        calendar.set(Calendar.MONTH, dentistVisitDTO.getSelectedMonth());
        calendar.set(Calendar.YEAR, dentistVisitDTO.getSelectedYear());


        Date visitDateTime = calendar.getTime();

        dentistVisitService.addVisit(dentistName, visitDateTime);

        return "redirect:/results";
    }

}



