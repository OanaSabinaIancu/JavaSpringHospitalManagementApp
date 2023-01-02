package com.example.demojdbc.controller;

import com.example.demojdbc.dto.PacientRequest;
import com.example.demojdbc.mapper.PacientMapper;
import com.example.demojdbc.model.Pacients;
import com.example.demojdbc.service.PacientService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    private final PacientService pacientService;

    private PacientMapper pacientMapper;

    public PacientController(PacientService pacientService, PacientMapper pacientMapper) {
        this.pacientService = pacientService;
        this.pacientMapper = pacientMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Pacients> savePacient(@RequestBody @Valid PacientRequest pacientRequest, @RequestParam int idMedic){
        return ResponseEntity.created(URI.create("/byID" + pacientRequest.getIdPacient()))
                .body(pacientService.saveNewPacient(pacientMapper.convertRequestToPacient(pacientRequest), idMedic));
    }

    @GetMapping("/")
    public ResponseEntity<List<Pacients>> getPacients(){
        return ResponseEntity.ok()
                .body(pacientService.getPacient());
    }

    @GetMapping("/filterByFirstName")
    public ResponseEntity<List<Pacients>> getPacientsByFirstName(@RequestParam String firstName){
        return ResponseEntity.ok()
                .body(pacientService.getPacientFilterFirstName(firstName));
    }

    @GetMapping("/filterByLastName")
    public ResponseEntity<List<Pacients>> getPacientsByLastName(@RequestParam String lastName){
        return ResponseEntity.ok()
                .body(pacientService.getPacientFilterLastName(lastName));
    }


}
