package com.example.demojdbc.controller;

import com.example.demojdbc.dto.SalonRequest;
import com.example.demojdbc.mapper.SalonMapper;
import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.model.Salon;
import com.example.demojdbc.repository.NurseRepository;
import com.example.demojdbc.service.SalonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SalonController.class)
class SalonControllerTest {
    private SalonMapper salonMapper;
    private NurseRepository nurseRepository;
    private SalonService salonService;
    @Test
    void saveSalon() {

        Nurse nurse = new Nurse();
        nurse.setIdNurse(1);
        nurse.setFirstName("Smith");
        nurse.setLastName("Jane");

        SalonRequest salonRequest = new SalonRequest();
        salonRequest.setIdSalon(1);
        salonRequest.setFloor(0);

        Salon salon = new Salon();
        salon.setIdSalon(1);
        salon.setFloor(0);
        salon.setNurse(nurse);

        // Mock the nurseRepository.findById method to return the mock nurse object

        when(nurseRepository.findById(1)).thenReturn(Optional.of(nurse));

        // Mock the salonMapper.convertRequestToSalon method to return the salon object
        when(salonMapper.convertRequestToSalon(salonRequest)).thenReturn(salon);

        // Mock the salonService.saveNewSalon method to return the salon object
        when(salonService.saveNewSalon(salon, 1)).thenReturn(salon);

        // Perform the HTTP POST request to the "/new" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<Salon> response = restTemplate.postForEntity("/new?idNurse=1", salonRequest, Salon.class);

        // Assert that the response status code is 201 (Created)
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Assert that the response body contains the salon object
        assertEquals(salon, response.getBody());
    }

    @Test
    void getSalon() {
        Nurse nurse = new Nurse();
        nurse.setIdNurse(1);
        nurse.setFirstName("Smith");
        nurse.setLastName("Jane");

        Salon salon1 = new Salon();
        salon1.setIdSalon(1);
        salon1.setFloor(0);
        salon1.setNurse(nurse);

        Salon salon2 = new Salon();
        salon2.setIdSalon(1);
        salon2.setFloor(0);
        salon2.setNurse(nurse);

        List<Salon> salonList = Arrays.asList(salon1, salon2);

        // Mock the salonService.getSalon method to return the list of salons
        when(salonService.getSalon()).thenReturn(salonList);

        // Perform the HTTP GET request to the "/" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Salon>> response = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Salon>>() {});

        // Assert that the response body contains the list of salons
        assertEquals(salonList, response.getBody());
    }

    @Test
    void getSalonByFloor() {
        Nurse nurse = new Nurse();
        nurse.setIdNurse(1);
        nurse.setFirstName("Smith");
        nurse.setLastName("Jane");

        Salon salon1 = new Salon();
        salon1.setIdSalon(1);
        salon1.setFloor(0);
        salon1.setNurse(nurse);

        Salon salon2 = new Salon();
        salon2.setIdSalon(1);
        salon2.setFloor(0);
        salon2.setNurse(nurse);

        List<Salon> salonList = Arrays.asList(salon1, salon2);

        // Mock the salonService.getSalonFilterFloor method to return the list of salons on floor 1
        when(salonService.getSalonFilterFloor(1)).thenReturn(Arrays.asList(salon1));

        // Perform the HTTP GET request to the "/filterByFloor" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Salon>> response = restTemplate.exchange("/filterByFloor?floor=1", HttpMethod.GET, null, new ParameterizedTypeReference<List<Salon>>() {});

        // Assert that the response body contains the list of salons on floor 1
        assertEquals(Arrays.asList(salon1), response.getBody());

    }
}