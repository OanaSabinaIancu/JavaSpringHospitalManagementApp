package com.example.demojdbc.controller;

import com.example.demojdbc.model.Shift;
import com.example.demojdbc.repository.ShiftRepository;
import com.example.demojdbc.service.ShiftService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ShiftController.class)
class ShiftControllerTest {
    private ShiftRepository shiftRepository;
    private ShiftService shiftService;

    @Autowired
    private MockMvc mvcShift;

    @Test
    void getShifts() throws Exception {
        Shift shift1 = new Shift();
        shift1.setIdShift(1);
        shift1.setShiftName("Day shift");

        Shift shift2 = new Shift();
        shift2.setIdShift(2);
        shift2.setShiftName("Night shift");


        List<Shift> shiftList = Arrays.asList(shift1, shift2);

        // Mock the shiftService.getShifts method to return the list of shifts
        when(shiftService.getShifts()).thenReturn(shiftList);

        // Perform the HTTP GET request to the "/list" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<List<Shift>> response = restTemplate.exchange("/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Shift>>() {});

        // Assert that the response body contains the list of shifts
        assertEquals(shiftList, response.getBody());
    }

    @Test
    void saveShift() {

        Shift shift = new Shift();
        shift.setIdShift(1);
        shift.setShiftName("Day shift");

        // Mock the shiftService.saveNewShift method to return the shift object
        when(shiftService.saveNewShift(shift)).thenReturn(shift);

        // Perform the HTTP POST request to the "/new" endpoint
        TestRestTemplate restTemplate = null;
        ResponseEntity<Shift> response = restTemplate.postForEntity("/new", shift, Shift.class);

        // Assert that the response status code is 200 (OK)
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Assert that the response body contains the shift object
        assertEquals(shift, response.getBody());
    }
}