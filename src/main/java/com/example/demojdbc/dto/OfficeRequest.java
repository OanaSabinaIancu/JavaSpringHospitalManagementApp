package com.example.demojdbc.dto;

import com.example.demojdbc.model.Medic;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OfficeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffice;

    @NotNull(message = "Floor can not be null")
    @NotEmpty(message = "Floor can not be empty")
    private int floor;

    @OneToOne(mappedBy = "office")
    private Medic medic;

    public OfficeRequest(int idOffice, int floor) {
        this.idOffice = idOffice;
        this.floor = floor;
    }

    public OfficeRequest() {

    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public int getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
