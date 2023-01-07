package com.example.demojdbc.controller;

import com.example.demojdbc.dto.MedicRequest;
import com.example.demojdbc.dto.SalonRequest;
import com.example.demojdbc.mapper.MedicMapper;
import com.example.demojdbc.mapper.SalonMapper;
import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Salon;
import com.example.demojdbc.service.MedicService;
import com.example.demojdbc.service.SalonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonController {
    private final SalonService salonService;

    private SalonMapper salonMapper;

    public SalonController(SalonService salonService, SalonMapper salonMapper) {
        this.salonService = salonService;
        this.salonMapper = salonMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Salon> saveSalon(@RequestBody @Valid SalonRequest salonRequest, @RequestParam int idNurse){
        return ResponseEntity.created(URI.create("/byID" + salonRequest.getIdSalon()))
                .body(salonService.saveNewSalon(salonMapper.convertRequestToSalon(salonRequest), idNurse));
    }

    @GetMapping("/")
    public ResponseEntity<List<Salon>> getSalon(){
        return ResponseEntity.ok()
                .body(salonService.getSalon());
    }

    @GetMapping("/filterByFloor")
    public ResponseEntity<List<Salon>> getSalonByFloor(@RequestParam int floor){
        return ResponseEntity.ok()
                .body(salonService.getSalonFilterFloor(floor));
    }


}
