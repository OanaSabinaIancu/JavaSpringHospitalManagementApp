package com.example.demojdbc.repository;

import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Pacients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacients, Integer> {
}
