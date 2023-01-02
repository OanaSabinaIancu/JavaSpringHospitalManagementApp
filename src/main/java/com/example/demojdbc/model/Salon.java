package com.example.demojdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalon;
    private int floor;

    @OneToMany(mappedBy = "salon")
    @JsonIgnore
    private List<Pacients> pacientsList;

    @OneToOne(mappedBy = "salon")
    private Nurse nurse;

    public Salon() {
    }

    public Salon(int idSalon, int floor) {
        this.idSalon = idSalon;
        this.floor = floor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }



    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}
