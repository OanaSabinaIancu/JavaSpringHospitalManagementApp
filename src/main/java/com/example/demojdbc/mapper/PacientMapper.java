package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.PacientRequest;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Pacients;
import org.springframework.stereotype.Component;

@Component
public class PacientMapper {

    public Pacients convertRequestToPacient(PacientRequest pacientRequest){
        return new Pacients(pacientRequest.getIdPacient(), pacientRequest.getFirstName(), pacientRequest.getLastName());
    }
}
