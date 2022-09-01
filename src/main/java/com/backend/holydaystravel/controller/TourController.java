package com.backend.holydaystravel.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/tour")
public class TourController {

    @GetMapping
    public ResponseEntity<List<String>> getTours() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{tourId}")
    public ResponseEntity<Object> getTour(@PathVariable Long tourId) {
        String tourDto = "Tour";
        return ResponseEntity.ok(tourDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTour(@RequestBody String tourDto) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{tourId}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long tourId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateTour(@RequestBody String tourDto) {
        return ResponseEntity.ok(tourDto);
    }
}
