package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Shift;
import com.example.demojdbc.repository.MedicRepository;
import com.example.demojdbc.repository.NurseRepository;
import com.example.demojdbc.repository.ShiftRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ShiftService {

    private final ShiftRepository shiftRepository;
    private final MedicRepository medicRepository;
    private final NurseRepository nurseRepository;

    public ShiftService(ShiftRepository shiftRepository,
                        MedicRepository medicRepository,
                        NurseRepository nurseRepository) {
        this.shiftRepository = shiftRepository;
        this.medicRepository = medicRepository;
        this.nurseRepository = nurseRepository;
    }

    public Shift saveShift(Shift shift, List<Integer> idmedics, List<Integer> idnurse){

        List<Medic> medicLists = medicRepository.findAllById(idmedics);

        List<Nurse> nursesList = nurseRepository.findAllById(idnurse);

        shift.setMedicList(medicLists);
        shift.setNurseList(nursesList);

        return shiftRepository.save(shift);
    }

    public List<Shift> getShifts(){
        return shiftRepository.findAll();
    }

    public Shift saveNewShift(Shift shift){
        return shiftRepository.save(shift);
    }
}
