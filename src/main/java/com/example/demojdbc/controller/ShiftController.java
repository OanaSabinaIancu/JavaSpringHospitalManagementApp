package com.example.demojdbc.controller;

import com.example.demojdbc.model.Medic;
import com.example.demojdbc.model.Shift;
import com.example.demojdbc.service.ShiftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shift")
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Shift>> getShifts(){
        return ResponseEntity.ok()
                .body(shiftService.getShifts());
    }

    @PostMapping("/new")
    public ResponseEntity<Shift> saveShift(@RequestBody Shift shift){
        return ResponseEntity.ok()
                .body(shiftService.saveNewShift(shift));
    }
}
