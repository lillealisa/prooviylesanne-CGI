package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.Dentist;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by serkp on 2.03.2017.
 */
public class DentistVisitDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    String selectedDentist;

    ArrayList<Dentist> dentists;


    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date visitTime;

    public DentistVisitDTO() {
        dentists= DentistVisitService.getDentists();
    }

    public DentistVisitDTO(String dentistName, Date visitTime) {
        this.dentistName = dentistName;
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

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
