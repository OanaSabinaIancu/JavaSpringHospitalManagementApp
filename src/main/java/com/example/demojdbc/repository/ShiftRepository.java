package com.example.demojdbc.repository;

import com.example.demojdbc.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
