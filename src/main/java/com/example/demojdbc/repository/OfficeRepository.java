package com.example.demojdbc.repository;

import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
