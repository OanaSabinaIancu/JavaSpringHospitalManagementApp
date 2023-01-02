package com.example.demojdbc.service;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.model.Shift;
import com.example.demojdbc.repository.MedicRepository;
import com.example.demojdbc.repository.PacientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    private PacientRepository pacientRepository;

    private MedicRepository medicRepository;

    public PacientService(PacientRepository pacientRepository, MedicRepository medicRepository) {
        this.pacientRepository = pacientRepository;
        this.medicRepository = medicRepository;
    }

    public Pacients saveNewPacient(Pacients pacients, int idMedic){
        Medic medic = medicRepository.findById(idMedic)
                .orElseThrow(() -> new RuntimeException("Id for medic entity is not valid "));
        pacients.setMedic(medic);

        return pacientRepository.save(pacients);
    }

    public List<Pacients> getPacient(){
        return pacientRepository.findAll();
    }

    public List<Pacients> getPacientFilterFirstName(String firstName){
        return pacientRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }
    public List<Pacients> getPacientFilterLastName(String lastName){
        return pacientRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }
}
