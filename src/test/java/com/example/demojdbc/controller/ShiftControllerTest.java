package com.example.demojdbc.controller;

import com.example.demojdbc.model.Shift;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ShiftController.class)
class ShiftControllerTest {

    @Autowired
    private MockMvc mvcShift;

    @Test
    void getShifts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/shift/list");
        MvcResult result=mvcShift.perform(requestBuilder).andReturn();
//        assertEquals("", result.getResponse().getContentASString());
    }

    @Test
    void saveShift() {
    }
}