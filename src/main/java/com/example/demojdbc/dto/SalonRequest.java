package com.example.demojdbc.dto;

import com.example.demojdbc.model.Pacients;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SalonRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalon;

    @NotNull(message = "Floor can not be null")
    @NotEmpty(message = "Floor can not be empty")
    private int floor;

    @OneToMany(mappedBy = "salon")
    @JsonIgnore
    private List<Pacients> pacientsList;

    public SalonRequest(int idSalon, int floor, List<Pacients> pacientsList) {
        this.idSalon = idSalon;
        this.floor = floor;
        this.pacientsList = pacientsList;
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

    public List<Pacients> getPacientsList() {
        return pacientsList;
    }

    public void setPacientsList(List<Pacients> pacientsList) {
        this.pacientsList = pacientsList;
    }
}
