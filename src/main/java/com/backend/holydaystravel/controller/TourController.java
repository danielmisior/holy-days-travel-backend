package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.dto.TourDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/tour")
public class TourController {

    @GetMapping
    public ResponseEntity<List<TourDto>> getTours() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{tourId}")
    public ResponseEntity<TourDto> getTour(@PathVariable Long tourId) {
        TourDto tourDto = new TourDto(1L, 1990.00, "Wroclaw", "Majorca", LocalDate.now());
        return ResponseEntity.ok(tourDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTour(@RequestBody TourDto tourDto) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{tourId}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long tourId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TourDto> updateTour(@RequestBody TourDto tourDto) {
        tourDto = new TourDto(2L, 2599.00, "Wroclaw", "Crete", LocalDate.now());
        return ResponseEntity.ok(tourDto);
    }
}
