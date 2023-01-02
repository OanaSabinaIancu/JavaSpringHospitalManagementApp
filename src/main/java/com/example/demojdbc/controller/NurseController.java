package com.example.demojdbc.controller;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Nurse;
import com.example.demojdbc.repository.ShiftRepository;
import com.example.demojdbc.service.NurseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
//        this.shiftRepository = shiftRepository;
        this.nurseService = nurseService;
    }

    @PostMapping("/nurse/new")
    public ResponseEntity<Nurse> saveNurse(@RequestBody Nurse nurse, @RequestParam int idshift){
        return ResponseEntity.ok()
                .body(nurseService.addNewNurse(nurse, idshift));
    }

    @GetMapping("/")
    public ResponseEntity<List<Nurse>> getNurse(){
        return ResponseEntity.ok()
                .body(nurseService.getNurses());
    }
}
