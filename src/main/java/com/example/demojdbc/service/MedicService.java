package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Shift;
import com.example.demojdbc.repository.MedicRepository;
import com.example.demojdbc.repository.ShiftRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {
    private final MedicRepository medicRepository;
    private final ShiftRepository shiftRepository;

    public MedicService(MedicRepository medicRepository,
                        ShiftRepository shiftRepository) {
        this.medicRepository = medicRepository;
        this.shiftRepository = shiftRepository;
    }

    public Medic saveNewMedic(Medic medic, int idShift){
        Shift shift = shiftRepository.findById(idShift)
                .orElseThrow(() -> new RuntimeException("Id for shift entity is not valid "));
        medic.setShift(shift);

        return medicRepository.save(medic);
    }

    public List<Medic> getMedics(){
        return medicRepository.findAll();
    }

    public List<Medic> getMedicsFilterFirstName(String firstName){
        return medicRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }
    public List<Medic> getMedicsFilterLastName(String lastName){
        return medicRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }
}
