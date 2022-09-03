package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TourRepositoryTestSuite {

    @Autowired
    private TourRepository tourRepository;
    private Tour tour;

    @BeforeEach
    void beforeEveryTest() {
        tour = Tour.builder()
                .tourPrice(1999.99).initiatoryPlace("Wroclaw")
                .destinationPlace("Majorca").departureDate(LocalDate.now())
                .build();
    }

    @Test
    void saveTourTest() {
        //Given
        tourRepository.save(tour);
        //When
        boolean exist = tourRepository.existsById(tour.getTourId());
        String initiatoryPlace = tourRepository.findById(tour.getTourId()).get().getInitiatoryPlace();
        double tourPrice = tourRepository.findById(tour.getTourId()).get().getTourPrice();
        //Then
        assertTrue(exist);
        assertEquals("Wroclaw", initiatoryPlace);
        assertEquals(1999.99, tourPrice);
        //CleanUp
        tourRepository.deleteById(tour.getTourId());
    }
}