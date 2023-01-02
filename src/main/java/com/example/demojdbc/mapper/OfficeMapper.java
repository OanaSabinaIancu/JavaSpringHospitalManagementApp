package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.OfficeRequest;
import com.example.demojdbc.model.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapper {
    public Office convertRequestToOffice(OfficeRequest officeRequest){
        return new Office(officeRequest.getIdOffice(), officeRequest.getFloor());
    }
}
