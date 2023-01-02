package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Shift;
import com.example.demojdbc.repository.NurseRepository;
import com.example.demojdbc.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    private final ShiftRepository shiftRepository;


    public NurseService(NurseRepository nurseRepository, ShiftRepository shiftRepository) {
        this.nurseRepository = nurseRepository;
        this.shiftRepository = shiftRepository;
    }

    public Nurse addNewNurse(Nurse nurse, int idShift){
        Shift shift = shiftRepository.findById(idShift)
                .orElseThrow(() -> new RuntimeException("Id for shift entity is not valid "));
        nurse.setShift(shift);
        return nurseRepository.save(nurse);
    }

    public List<Nurse> getNurses(){
        return nurseRepository.findAll();
    }

}
