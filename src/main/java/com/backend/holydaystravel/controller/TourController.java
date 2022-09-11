package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.domain.dto.TourDto;
import com.backend.holydaystravel.exception.TourNotFoundException;
import com.backend.holydaystravel.facade.TourFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/tour")
public class TourController {
    private final TourFacade tourFacade;

    @GetMapping
    public ResponseEntity<List<TourDto>> getTours() {
        return ResponseEntity.ok(tourFacade.getAllTours());
    }

    @GetMapping(value = "{tourId}")
    public ResponseEntity<TourDto> getTour(@PathVariable Long tourId) throws TourNotFoundException {
        return ResponseEntity.ok(tourFacade.getTour(tourId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTour(@RequestBody TourDto tourDto) {
        tourFacade.createTour(tourDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{tourId}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long tourId) throws TourNotFoundException {
        tourFacade.deleteTour(tourId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TourDto> updateTour(@RequestBody TourDto tourDto) throws TourNotFoundException {
       return ResponseEntity.ok(tourFacade.updateTour(tourDto));
    }
}
