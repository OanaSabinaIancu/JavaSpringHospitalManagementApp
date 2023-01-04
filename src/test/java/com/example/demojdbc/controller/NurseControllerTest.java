package com.example.demojdbc.controller;

import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.service.NurseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(NurseController.class)
class NurseControllerTest {

    @Test
    void saveNurse() {
        // Create a mock Nurse object and set its fields
        Nurse nurse = new Nurse();
        nurse.setIdNurse(1);
        nurse.setFirstName("John");
        nurse.setLastName("Doe");

        // Create a mock NurseService object and specify its behavior
        NurseService nurseService = mock(NurseService.class);
        when(nurseService.addNewNurse(nurse, 1)).thenReturn(nurse);

        // Create a NurseController object and inject the mock NurseService object
        NurseController nurseController = new NurseController(nurseService);

        // Call the saveNurse method and verify the result
        ResponseEntity<Nurse> result = nurseController.saveNurse(nurse, 1);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(nurse, result.getBody());
    }

    @Test
    void getNurse() {
        // Create a list of mock Nurse objects
        List<Nurse> nurses = new ArrayList<>();
        Nurse nurse1 = new Nurse();
        nurse1.setIdNurse(1);
        nurse1.setFirstName("John");
        nurse1.setLastName("Doe");
        nurses.add(nurse1);
        Nurse nurse2 = new Nurse();
        nurse2.setIdNurse(2);
        nurse2.setFirstName("Jane");
        nurse2.setLastName("Doe");
        nurses.add(nurse2);

        // Create a mock NurseService object and specify its behavior
        NurseService nurseService = mock(NurseService.class);
        when(nurseService.getNurses()).thenReturn(nurses);

        // Create a NurseController object and inject the mock NurseService object
        NurseController nurseController = new NurseController(nurseService);

        // Call the getNurse method and verify the result
        ResponseEntity<List<Nurse>> result = nurseController.getNurse();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(nurses, result.getBody());
    }
}