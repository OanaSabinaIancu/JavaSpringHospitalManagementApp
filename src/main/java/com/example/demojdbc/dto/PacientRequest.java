package com.example.demojdbc.dto;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Salon;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PacientRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPacient;

    @NotNull(message = "First name can not be null")
    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="id_medic")
    private Medic medic;

    @ManyToOne
    @JoinColumn(name="id_salon")
    private Salon salon;

    public PacientRequest(int idPacient, String firstName, String lastName, Medic medic, Salon salon) {
        this.idPacient = idPacient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medic = medic;
        this.salon = salon;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
