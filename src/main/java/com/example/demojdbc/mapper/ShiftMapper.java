package com.example.demojdbc.mapper;

import com.example.demojdbc.dto.ShiftRequest;
import com.example.demojdbc.model.Shift;

public class ShiftMapper {
    public Shift convertRequestToShift(ShiftRequest shiftRequest){
        return new Shift(shiftRequest.getIdShift(), shiftRequest.getShiftName());
    }
}