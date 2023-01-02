package com.example.demojdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Shift {

//    Tranzactii:

//    ACID = Atomic Consistent Izolat Durabil
//    atomic = modifica o anumita particica, izolat = trebuie sa se poata exc in context propriu fara sa intervina cu alte actiuni

//    La ce sunt bune:
//    presupunem ca vrem sa scoatem 200 de lei, dar bancomatul are doar 100 atunci banca nu imi permite sa extrag banii

//    IMPLEMENTEAZA ASTA: POTI INTRODUCE DE MANA N PACIENTI, DAR STII CA AI DISPONIBIELE DOAR 200 DE LOCURI IN SPITAL, DACA VREI SA INTRODUCI
//    MAI MULTE PERSOANE AI EROARE

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShift;
    private String shiftName;

//    for not showing this collumn on get functions

    @OneToMany(mappedBy = "shiftnurse")
    @JsonIgnore
//    @JoinColumn(name = "id_nurse")
    private List<Nurse> nurseList = new ArrayList<>();

    @OneToMany(mappedBy = "shiftmedic")
//    @JsonIgnore
//    @JoinColumn(name = "id_medic")
    private List<Medic> medicList = new ArrayList<>();

    public Shift() {
    }

    public Shift(int idShift, String shiftName) {
        this.idShift = idShift;
        this.shiftName = shiftName;
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
