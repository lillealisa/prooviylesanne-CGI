package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.Dentist;
import com.cgi.dentistapp.DentistAppApplication;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by serkp on 2.03.2017.
 */
public class DentistVisitDTO {

    String selectedDentist;

    ArrayList<Dentist> dentists;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date visitTime;
    LinkedHashMap<Integer, String> availableHours = DentistAppApplication.getAvailableHours();

    Integer selectedHour;

    public DentistVisitDTO() {
        dentists= DentistVisitService.getDentists();
    }

    public DentistVisitDTO(String dentistName, Date visitTime) {
        this.visitTime = visitTime;
        dentists= DentistVisitService.getDentists();
    }

    public String getSelectedDentist() {
        return selectedDentist;
    }

    public void setSelectedDentist(String selectedDentist) {
        this.selectedDentist = selectedDentist;
    }

    public ArrayList<Dentist> getDentists() {
        return dentists;
    }

    public void setDentists(ArrayList<Dentist> dentists) {
        this.dentists = dentists;
    }


    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public LinkedHashMap<Integer, String> getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(LinkedHashMap<Integer, String> availableHours) {
        this.availableHours = availableHours;
    }

    public Integer getSelectedHour() {
        return selectedHour;
    }

    public void setSelectedHour(Integer selectedHour) {
        this.selectedHour = selectedHour;
    }

}
