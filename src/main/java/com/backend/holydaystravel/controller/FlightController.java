package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.domain.dto.FlightDto;
import com.backend.holydaystravel.exception.FlightNotFoundException;
import com.backend.holydaystravel.facade.FlightFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/flight")
public class FlightController {
    private final FlightFacade flightFacade;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        return ResponseEntity.ok(flightFacade.getAllFlights());
    }

    @GetMapping(value = "{flightId}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        return ResponseEntity.ok(flightFacade.getFlight(flightId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        flightFacade.createFlight(flightDto);
        return ResponseEntity.ok(flightFacade.createFlight(flightDto));
    }

    @DeleteMapping(value = "{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        flightFacade.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto) throws FlightNotFoundException {
        return ResponseEntity.ok(flightFacade.updateFlight(flightDto));
    }
}
