package com.example.demojdbc.model;

import jakarta.persistence.*;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffice;
    private int floor;

    @OneToOne(mappedBy = "office")
    private Medic medic;

    public Office() {
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Office(int idOffice, int floor) {
        this.idOffice = idOffice;
        this.floor = floor;
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
