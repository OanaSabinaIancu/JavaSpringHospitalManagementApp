package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.model.Salon;
import com.example.demojdbc.repository.NurseRepository;
import com.example.demojdbc.repository.SalonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    private NurseRepository nurseRepository;

    private SalonRepository salonRepository;

    public SalonService(NurseRepository nurseRepository, SalonRepository salonRepository) {
        this.nurseRepository = nurseRepository;
        this.salonRepository = salonRepository;
    }

    public Salon saveNewSalon(Salon salon, int idNurse){
        Nurse nurse = nurseRepository.findById(idNurse)
                .orElseThrow(() -> new RuntimeException("Id for nurse entity is not valid "));
        salon.setNurse(nurse);

        return salonRepository.save(salon);
    }

    public List<Salon> getSalon(){
        return salonRepository.findAll();
    }

    public List<Salon> getSalonFilterFloor(int floor){
        return salonRepository.findAll(Sort.by(Sort.Direction.ASC, "floor"));
    }
}
