package com.example.demojdbc.dto;

import com.example.demojdbc.model.Office;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.model.Shift;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MedicRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedic;

    @NotNull(message = "First Name can not be null")
    @NotBlank(message = "First Name can not be blank")
    private String firstName;

    @NotNull(message = "Last Name can not be null")
    @NotBlank(message = "Last Name can not be blank")
    private String lastName;

    @NotNull(message = "Age can not be null")
    @NotBlank(message = "Age can not be blank")
    private int age;

    @NotNull(message = "Specialty can not be null")
    @NotBlank(message = "Specialty can not be blank")
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "id_shift")
    private Shift shiftmedic;

    @OneToMany(mappedBy = "medic")
    @JsonIgnore
    private List<Pacients> pacientsList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_office")
    private Office office;

    public MedicRequest() {
    }

    public MedicRequest(int idMedic, String firstName, String lastName, int age, String specialty, Shift shiftmedic, List<Pacients> pacientsList, Office office) {
        this.idMedic = idMedic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.specialty = specialty;
        this.shiftmedic = shiftmedic;
        this.pacientsList = pacientsList;
        this.office = office;
    }

    public MedicRequest(int idMedic, String firstName, String lastName, int age, String specialty) {
        this.idMedic = idMedic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.specialty = specialty;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Shift getShiftmedic() {
        return shiftmedic;
    }

    public void setShiftmedic(Shift shiftmedic) {
        this.shiftmedic = shiftmedic;
    }

    public List<Pacients> getPacientsList() {
        return pacientsList;
    }

    public void setPacientsList(List<Pacients> pacientsList) {
        this.pacientsList = pacientsList;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
