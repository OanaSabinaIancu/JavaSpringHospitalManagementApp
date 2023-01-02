package com.example.demojdbc.repository;

import com.example.demojdbc.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Integer> {
}
