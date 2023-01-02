package com.example.demojdbc.repository;

import com.example.demojdbc.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Integer> {
}
