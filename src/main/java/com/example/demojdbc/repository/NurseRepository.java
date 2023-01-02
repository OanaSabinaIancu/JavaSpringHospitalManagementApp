package com.example.demojdbc.repository;

import com.example.demojdbc.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {



//    query without jpql

//    Nurse findNurseByFirstname(String firstName);

//    query with jpql

//    @Query("select n from Nurse n where n.nurseName = :firstName")
//    Nurse findNurseByFirstnameJpql(@Param("firstName") String firstName);

//    query with classic sql

//    @Query(value = "select * from Nurse where firstName = :firstName", nativeQuery = true)
//    Nurse findNurseByNurseFirstNameWithNativeQuery(String firstName);
}
