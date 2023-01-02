package com.example.demojdbc.model;

import jakarta.persistence.*;

@Entity
public class Pacients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPacient;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name="id_medic")
    private Medic medic;

    @ManyToOne
    @JoinColumn(name="id_salon")
    private Salon salon;

    public Pacients() {
    }

    public Pacients(int idPacient, String firstName, String lastName) {
        this.idPacient = idPacient;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
