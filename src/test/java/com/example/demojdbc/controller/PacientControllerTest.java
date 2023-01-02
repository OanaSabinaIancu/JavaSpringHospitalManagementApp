package com.example.demojdbc.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PacientController.class)
class PacientControllerTest {

    @Test
    void savePacient() {
    }

    @Test
    void getPacients() {
    }

    @Test
    void getPacientsByFirstName() {
    }

    @Test
    void getPacientsByLastName() {
    }
}