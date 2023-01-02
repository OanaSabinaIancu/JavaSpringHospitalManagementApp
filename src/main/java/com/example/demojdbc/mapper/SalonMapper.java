package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.SalonRequest;
import com.example.demojdbc.model.Salon;

public class SalonMapper {
    public Salon convertRequestToSalon(SalonRequest salonRequest){
        return new Salon(salonRequest.getIdSalon(), salonRequest.getFloor());
    }
}
