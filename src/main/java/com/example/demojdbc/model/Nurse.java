package com.example.demojdbc.model;

import jakarta.persistence.*;

@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNurse;
    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_shift")
    private Shift shiftnurse;

    @OneToOne
    @JoinColumn(name = "id_salon")
    private Salon salon;

    public Nurse() {
    }

    public Shift getShift() {
        return shiftnurse;
    }

    public void setShift(Shift shift) {
        this.shiftnurse = shift;
    }

    public Nurse(int idNurse, String firstName, String lastName, int age) {
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

    @Override
    public String toString() {
        return "Nurse{" +
                "idNurse=" + idNurse +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
