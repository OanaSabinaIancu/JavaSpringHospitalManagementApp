package com.example.demojdbc.controller;

import com.example.demojdbc.dto.OfficeRequest;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Office;
import com.example.demojdbc.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OfficeController.class)
class OfficeControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfficeService officeService;

    @Test
    void saveOffice() {
        // Create an OfficeRequest object and set its fields
        OfficeRequest officeRequest = new OfficeRequest();
        officeRequest.setIdOffice(1);
        officeRequest.setFloor(1);

        // Create a mock Office object and set its fields
        Office office = new Office();
        office.setIdOffice(1);
        office.setFloor(1);

        // Create a mock OfficeService object and specify its behavior
        OfficeService officeService = mock(OfficeService.class);
        when(officeService.saveNewOffice(office, 1)).thenReturn(office);

        // Create an OfficeController object and inject the mock OfficeService object
        OfficeController officeController = new OfficeController(officeService);

        // Call the saveOffice method and verify the result
        ResponseEntity<Office> result = officeController.saveOffice(officeRequest, 1);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(office, result.getBody());
    }

    @Test
    void getOffice() {
        // Create a list of mock Office objects
        List<Office> offices = new ArrayList<>();
        Office office1 = new Office();
        office1.setIdOffice(1);
        office1.setFloor(1);
        offices.add(office1);
        Office office2 = new Office();
        office2.setIdOffice(2);
        office2.setFloor(1);
        offices.add(office2);

        // Create a mock OfficeService object and specify its behavior
        OfficeService officeService = mock(OfficeService.class);
        when(officeService.getOffice()).thenReturn(offices);

        // Create an OfficeController object and inject the mock OfficeService object
        OfficeController officeController = new OfficeController(officeService);

        // Call the getOffice method and verify the result
        ResponseEntity<List<Office>> result = officeController.getOffice();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(offices, result.getBody());
    }

    @Test
    void getOfficeByFloor () throws Exception {
        // Given
        int floor = 1;
        Office office1 = new Office();
        office1.setMedic(new Medic(1,"John", "Doe", 30, "cardiologist"));
        office1.setIdOffice(1);
        office1.setFloor(1);
        Office office2 = new Office();
        office2.setIdOffice(1);
        office2.setFloor(1);
        office1.setMedic(new Medic(1,"Jane", "Doe", 30, "radiologist"));

        List<Office> offices = Arrays.asList(office1, office2);

        given(officeService.getOfficeFilterFloor(floor)).willReturn(offices);

        // When
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/filterByFloor?floor=" + floor)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Then


    }
}