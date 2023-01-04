package com.example.demojdbc.controller;

import com.example.demojdbc.dto.MedicRequest;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.service.MedicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicController.class)
class MedicControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void saveMedic() {
        MedicRequest medicRequest = new MedicRequest();
        medicRequest.setIdMedic(1);
        medicRequest.setFirstName("John");
        medicRequest.setLastName("Doe");
        medicRequest.setSpecialty("Pediatrics");

        // Create a mock Medic object and set its fields
        Medic medic = new Medic();
        medic.setIdMedic(1);
        medic.setFirstName("John");
        medic.setLastName("Doe");
        medic.setSpecialty("Pediatrics");

        // Create a mock MedicService object and specify its behavior
        MedicService medicService = mock(MedicService.class);
        when(medicService.saveNewMedic(medic, 1)).thenReturn(medic);

        // Create a MedicController object and inject the mock MedicService object
        MedicController medicController = new MedicController(medicService);

        // Call the saveMedic method and verify the result
        ResponseEntity<Medic> result = medicController.saveMedic(medicRequest, 1);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals("medic/byID1", result.getHeaders().getLocation().toString());
        assertEquals(medic, result.getBody());
    }

    @Test
    void getMedic() {
        // Create a list of mock Medic objects
        List<Medic> medics = new ArrayList<>();
        Medic medic1 = new Medic();
        medic1.setIdMedic(1);
        medic1.setFirstName("John");
        medic1.setLastName("Doe");
        medic1.setSpecialty("Pediatrics");
        medics.add(medic1);
        Medic medic2 = new Medic();
        medic2.setIdMedic(2);
        medic2.setFirstName("Jane");
        medic2.setLastName("Doe");
        medic2.setSpecialty("Surgery");
        medics.add(medic2);

        // Create a mock MedicService object and specify its behavior
        MedicService medicService = mock(MedicService.class);
        when(medicService.getMedics()).thenReturn(medics);

        // Create a MedicController object and inject the mock MedicService object
        MedicController medicController = new MedicController(medicService);

        // Call the getMedic method and verify the result
        ResponseEntity<List<Medic>> result = medicController.getMedic("", "", 0, "");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(medics, result.getBody());
    }

    @Test
    void getMedicByFirstName() {
        // Create a list of mock Medic objects
        List<Medic> medics = new ArrayList<>();
        Medic medic1 = new Medic();
        medic1.setIdMedic(1);
        medic1.setFirstName("John");
        medic1.setLastName("Doe");
        medic1.setSpecialty("Pediatrics");
        medics.add(medic1);
        Medic medic2 = new Medic();
        medic2.setIdMedic(2);
        medic2.setFirstName("Jane");
        medic2.setLastName("Doe");
        medic2.setSpecialty("Surgery");
        medics.add(medic2);

        // Create a mock MedicService object and specify its behavior
        MedicService medicService = mock(MedicService.class);
        when(medicService.getMedicsFilterFirstName("John")).thenReturn(medics);

        // Create a MedicController object and inject the mock MedicService object
        MedicController medicController = new MedicController(medicService);

        // Call the getMedicByFirstName method and verify the result
        ResponseEntity<List<Medic>> result = medicController.getMedicByFirstName("John");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(medics, result.getBody());
    }

    @Test
    void getMedicByLatName() {
        // Create a list of mock Medic objects
        List<Medic> medics = new ArrayList<>();
        Medic medic1 = new Medic();
        medic1.setIdMedic(1);
        medic1.setFirstName("John");
        medic1.setLastName("Doe");
        medic1.setSpecialty("Pediatrics");
        medics.add(medic1);
        Medic medic2 = new Medic();
        medic2.setIdMedic(2);
        medic2.setFirstName("Jane");
        medic2.setLastName("Doe");
        medic2.setSpecialty("Surgery");
        medics.add(medic2);

        // Create a mock MedicService object and specify its behavior
        MedicService medicService = mock(MedicService.class);
        when(medicService.getMedicsFilterLastName("Doe")).thenReturn(medics);

        // Create a MedicController object and inject the mock MedicService object
        MedicController medicController = new MedicController(medicService);

        // Call the getMedicByLastName method and verify the result
        ResponseEntity<List<Medic>> result = medicController.getMedicByLatName("Doe");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(medics, result.getBody());
    }

    @Test
    void multipleAddMedic() {
        // Create a MedicRequest object and set its fields
        MedicRequest medicRequest = new MedicRequest();
        medicRequest.setIdMedic(1);
        medicRequest.setFirstName("John");
        medicRequest.setLastName("Doe");
        medicRequest.setSpecialty("Pediatrics");

        // Create a mock MedicService object and specify its behavior
        MedicService medicService = mock(MedicService.class);
        when(medicService.multipleIntroduction(21)).thenReturn("21 medics added successfully");

        // Create a MedicController object and inject the mock MedicService object
        MedicController medicController = new MedicController(medicService);

        // Call the multipleAddMedic method and verify the result
        ResponseEntity<String> result = medicController.multipleAddMedic(medicRequest, 1);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("21 medics added successfully", result.getBody());
    }
}