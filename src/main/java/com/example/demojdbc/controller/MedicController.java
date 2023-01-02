package com.example.demojdbc.controller;

import com.example.demojdbc.dto.MedicRequest;
import com.example.demojdbc.mapper.MedicMapper;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.service.MedicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medic")
public class MedicController {

    private final MedicService medicService;

    private MedicMapper medicMapper;

    public MedicController(MedicService medicService, MedicMapper medicMapper) {
        this.medicService = medicService;
        this.medicMapper = medicMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Medic> saveMedic(@RequestBody @Valid MedicRequest medicRequest, @RequestParam int idshift){
        return ResponseEntity.created(URI.create("medic/byID" + medicRequest.getIdMedic()))
                .body(medicService.saveNewMedic(medicMapper.convertRequestToMedic(medicRequest), idshift));
    }

    @GetMapping("/")
    public ResponseEntity<List<Medic>> getMedic(@RequestParam(value = " ", defaultValue = "") String firstName, String lastName, int Age, String Specialty){
        return ResponseEntity.ok()
                .body(medicService.getMedics());
    }

    @GetMapping("/filterByFirstName")
    public ResponseEntity<List<Medic>> getMedicByFirstName(@RequestParam String firstName){
        return ResponseEntity.ok()
                .body(medicService.getMedicsFilterFirstName(firstName));
    }

    @GetMapping("/filterByLastName")
    public ResponseEntity<List<Medic>> getMedicByLatName(@RequestParam String lastName){
        return ResponseEntity.ok()
                .body(medicService.getMedicsFilterLastName(lastName));
    }

    @Transactional
    @PostMapping("/new/multiple")
    public ResponseEntity<String> multipleAddMedic(@RequestBody @Valid MedicRequest medicRequest, @RequestParam int idshift){
        return ResponseEntity.ok()
                .body(medicService.multipleIntroduction(21));
    }

}
