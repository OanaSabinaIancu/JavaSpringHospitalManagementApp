package com.example.demojdbc.controller;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.repository.MedicRepository;
import com.example.demojdbc.repository.PacientRepository;
import com.example.demojdbc.service.PacientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PacientController.class)
class PacientControllerTest {

    private PacientRepository pacientRepository;

    private MedicRepository medicRepository;

    private PacientService pacientService;

    @Test
    void savePacient() {
        Medic medic = new Medic(1, "John", "Smith", 30, "Cardiology");


        Pacients pacients = new Pacients(1, "Jane", "Doe");

        pacients.setMedic(medic);

        // Mock the medicRepository.findById method to return the mock medic object
        when(medicRepository.findById(1)).thenReturn(Optional.of(medic));

        // Mock the pacientRepository.save method to return the pacients object that was passed to it
        when(pacientRepository.save(pacients)).thenReturn(pacients);

        // Call the saveNewPacient method and assert that it returns the expected pacients object
        assertEquals(pacients, pacientService.saveNewPacient(pacients, 1));
    }

    @Test
    void getPacients() {
        Pacients pacient1 = new Pacients(1, "Jane", "Doe");

        Pacients pacient2 = new Pacients(2, "John", "Smith");

        List<Pacients> pacientsList = Arrays.asList(pacient1, pacient2);

        // Mock the pacientService.getPacient method to return the list of pacients
        when(pacientService.getPacient()).thenReturn(pacientsList);

        // Perform the HTTP GET request to the "/" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Pacients>> response = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pacients>>() {});

        // Assert that the response body contains the list of pacients
        assertEquals(pacientsList, response.getBody());
    }

    @Test
    void getPacientsByFirstName() {

        Pacients pacient1 = new Pacients(1, "Jane", "Doe");

        Pacients pacient2 = new Pacients(2, "John", "Smith");

        List<Pacients> pacientsList = Arrays.asList(pacient1, pacient2);

        // Mock the pacientService.getPacientFilterFirstName method to return the list of pacients
        when(pacientService.getPacientFilterFirstName("Jane")).thenReturn(Arrays.asList(pacient1));

        // Perform the HTTP GET request to the "/filterByFirstName" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Pacients>> response = restTemplate.exchange("/filterByFirstName?firstName=Jane", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pacients>>() {});

        // Assert that the response body contains the list of pacients
        assertEquals(Arrays.asList(pacient1), response.getBody());

    }

    @Test
    void getPacientsByLastName() {
        Pacients pacient1 = new Pacients(1, "Jane", "Doe");

        Pacients pacient2 = new Pacients(2, "John", "Smith");

        List<Pacients> pacientsList = Arrays.asList(pacient1, pacient2);

        // Mock the pacientService.getPacientFilterLastName method to return the list of pacients
        when(pacientService.getPacientFilterLastName("Doe")).thenReturn(Arrays.asList(pacient1));

        // Perform the HTTP GET request to the "/filterByFirstName" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Pacients>> response = restTemplate.exchange("/filterByFirstName?lastName=Smith", HttpMethod.GET, null, new ParameterizedTypeReference<List<Pacients>>() {});

        // Assert that the response body contains the list of pacients
        assertEquals(Arrays.asList(pacient1), response.getBody());
    }
}