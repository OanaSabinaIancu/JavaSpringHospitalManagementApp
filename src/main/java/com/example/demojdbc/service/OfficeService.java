package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Office;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.repository.MedicRepository;
import com.example.demojdbc.repository.OfficeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {

    private OfficeRepository officeRepository;

    private MedicRepository medicRepository;

    public Office saveNewOffice(Office office, int idMedic){
        Medic medic = medicRepository.findById(idMedic)
                .orElseThrow(() -> new RuntimeException("Id for medic entity is not valid "));
        office.setMedic(medic);

        return officeRepository.save(office);
    }

    public List<Office> getOffice(){
        return officeRepository.findAll();
    }

    public List<Office> getOfficeFilterFloor(int floor){
        return officeRepository.findAll(Sort.by(Sort.Direction.ASC, "floor"));
    }

    public OfficeService(OfficeRepository officeRepository, MedicRepository medicRepository) {
        this.officeRepository = officeRepository;
        this.medicRepository = medicRepository;
    }
}
