package com.example.demojdbc.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MedicController.class)
class MedicControllerTest {

    @Test
    void saveMedic() {
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