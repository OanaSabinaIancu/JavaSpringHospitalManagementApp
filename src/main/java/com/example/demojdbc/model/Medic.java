package com.example.demojdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedic;
    private String firstName;
    private String lastName;
    private int age;
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

    public Medic() {
    }

    public Medic(int idMedic, String firstName, String lastName, int age, String specialty) {
        this.idMedic = idMedic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public Shift getShift() {
        return shiftmedic;
    }

    public void setShift(Shift shift) {
        this.shiftmedic = shift;
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

    @Override
    public String toString() {
        return "Medic{" +
                "idMedic=" + idMedic +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
