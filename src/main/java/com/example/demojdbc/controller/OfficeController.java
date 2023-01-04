package com.example.demojdbc.controller;

import com.example.demojdbc.dto.OfficeRequest;
import com.example.demojdbc.mapper.OfficeMapper;
import com.example.demojdbc.model.Office;
import com.example.demojdbc.service.OfficeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    private OfficeMapper officeMapper;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Office> saveOffice(@RequestBody @Valid OfficeRequest officeRequest, @RequestParam int idMedic){
        return ResponseEntity.created(URI.create("/byID" + officeRequest.getIdOffice()))
                .body(officeService.saveNewOffice(officeMapper.convertRequestToOffice(officeRequest), idMedic));
    }

    @GetMapping("/")
    public ResponseEntity<List<Office>> getOffice(){
        return ResponseEntity.ok()
                .body(officeService.getOffice());
    }

    @GetMapping("/filterByFloor")
    public ResponseEntity<List<Office>> getOfficeByFloor(@RequestParam int floor){
        return ResponseEntity.ok()
                .body(officeService.getOfficeFilterFloor(floor));
    }


}
