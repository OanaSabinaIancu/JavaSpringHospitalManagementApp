package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.MedicRequest;
import com.example.demojdbc.model.Medic;
import org.springframework.stereotype.Component;

@Component
public class MedicMapper {
    public Medic convertRequestToMedic(MedicRequest medicRequest){
        return new Medic(medicRequest.getIdMedic(), medicRequest.getFirstName(), medicRequest.getLastName(), medicRequest.getAge(), medicRequest.getSpecialty());
    }
}
