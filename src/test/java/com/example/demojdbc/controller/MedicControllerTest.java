package com.example.demojdbc.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicController.class)
class MedicControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIfMockMvcIsAutowired() {
        assertNotNull(mvc);

    }

    @Test
    void testMedicWithoutFirstNameParameter() throws Exception {
        mvc.perform(get("/course"))
                .andExpect(status().isOk())
                .andExpect(view().name("course"))
                .andExpect(model().attribute("code", "001"));
    }

    @Test
    void testCourseWithCodeParameter() throws Exception {
        mvc.perform(get("/course?code=007"))
                .andExpect(status().isOk())
                .andExpect(view().name("course"))
                .andExpect(model().attribute("code", "007"));
    }

    @Test
    void saveMedic() throws Exception {
    }

    @Test
    void getMedic() {
    }

    @Test
    void getMedicByFirstName() {
    }

    @Test
    void getMedicByLatName() {
    }
}