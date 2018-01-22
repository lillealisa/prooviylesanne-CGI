package com.cgi.dentistapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.cgi.dentistapp.Dentist;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dentistapp.dao.DentistVisitDao;
import com.cgi.dentistapp.dao.entity.DentistVisitEntity;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    private DentistVisitDao dentistVisitDao;

    public void addVisit(String dentistName, Date visitTime) {
        DentistVisitEntity visit = new DentistVisitEntity(dentistName, visitTime);
        dentistVisitDao.create(visit);
    }

    public List<DentistVisitEntity> listVisits () {
        return dentistVisitDao.getAllVisits();
    }
    public Dentist getDentistByID(String id)
    {
        ArrayList<Dentist> dentists = this.getDentists();

        for(Dentist dentist : dentists) {
            if (dentist.id == id) {
                return dentist;
            }
        }

        return null;
    }
    public static ArrayList<Dentist> getDentists() {
        Dentist arst1 = new Dentist("arst1", "Doktor Pille");
        Dentist arst2 = new Dentist("arst2", "Doktor Millie");
        Dentist arst3 = new Dentist("arst3", "Doktor Dillie");
        Dentist arst4 = new Dentist("arst4", "Doktor House");
        Dentist arst5 = new Dentist("arst5", "Doktor Who");
        ArrayList<Dentist> dentists= new ArrayList<Dentist>();
        dentists.add(arst1);
        dentists.add(arst2);
        dentists.add(arst3);
        dentists.add(arst4);
        dentists.add(arst5);
        return dentists;

    }
}
