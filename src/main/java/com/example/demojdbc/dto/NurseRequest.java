package com.example.demojdbc.dto;

import com.example.demojdbc.model.Shift;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class NurseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNurse;

    @NotNull(message = "First Name can not be null")
    @NotEmpty(message = "First Name can not be empty")
    private String firstName;

    @NotNull(message = "Last Name can not be null")
    @NotEmpty(message = "Last Name can not be empty")
    private String lastName;

    @NotNull(message = "Age can not be null")
    @NotEmpty(message = "Age can not be empty")
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_shift")
    private Shift shiftnurse;

    public NurseRequest() {
    }

    public NurseRequest(int idNurse, String firstName, String lastName, int age) {
        this.idNurse = idNurse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getIdNurse() {
        return idNurse;
    }

    public void setIdNurse(int idNurse) {
        this.idNurse = idNurse;
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

    public Shift getShiftnurse() {
        return shiftnurse;
    }

    public void setShiftnurse(Shift shiftnurse) {
        this.shiftnurse = shiftnurse;
    }
}
