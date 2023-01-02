package com.example.demojdbc.dto;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShiftRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShift;

    @NotNull(message = "Shift name can not be null")
    @NotEmpty(message = "Shift name can not be empty")
    private String shiftName;

//    for not showing this collumn on get functions

    @OneToMany(mappedBy = "shiftnurse")
//    @JsonIgnore
//    @JoinColumn(name = "id_nurse")
    private List<Nurse> nurseList = new ArrayList<>();

    @OneToMany(mappedBy = "shiftmedic")
//    @JsonIgnore
//    @JoinColumn(name = "id_medic")
    private List<Medic> medicList = new ArrayList<>();

    public ShiftRequest(int idShift, String shiftName, List<Nurse> nurseList, List<Medic> medicList) {
        this.idShift = idShift;
        this.shiftName = shiftName;
        this.nurseList = nurseList;
        this.medicList = medicList;
    }

    public int getIdShift() {
        return idShift;
    }

    public void setIdShift(int idShift) {
        this.idShift = idShift;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public List<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(List<Nurse> nurseList) {
        this.nurseList = nurseList;
    }

    public List<Medic> getMedicList() {
        return medicList;
    }

    public void setMedicList(List<Medic> medicList) {
        this.medicList = medicList;
    }
}
