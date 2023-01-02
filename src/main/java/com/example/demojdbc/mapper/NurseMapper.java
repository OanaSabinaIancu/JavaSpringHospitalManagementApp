package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.NurseRequest;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;

public class NurseMapper {
    public Nurse convertRequestToNurse(NurseRequest nurseRequest){
        return new Nurse(nurseRequest.getIdNurse(), nurseRequest.getFirstName(), nurseRequest.getLastName(), nurseRequest.getAge());
    }
}
