package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TourRepositoryTestSuite {

    @Autowired
    private TourRepository tourRepository;
    private Tour tour;

    @BeforeEach
    void beforeEveryTest() {
        tour = Tour.builder()
                .tourPrice(1999.99)
                .initiatoryPlace("Wroclaw")
                .destinationPlace("Majorca")
                .departureDate(LocalDate.now())
                .returnDate(LocalDate.now().plusDays(7))
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

    @Test
    void findTourById() {
        //Given
        tourRepository.save(tour);
        //When
        Long id = tour.getTourId();
        Tour result = tourRepository.findById(id).get();
        //Then
        assertEquals("Wroclaw", result.getInitiatoryPlace());
        assertEquals(1999.99, result.getTourPrice());
        //CleanUp
        tourRepository.deleteById(id);
    }

    @Test
    void findAllTours() {
        //Given
        tourRepository.save(tour);
        Tour tour2 = Tour.builder().tourPrice(2000.00).initiatoryPlace("test")
                .destinationPlace("test").departureDate(LocalDate.now()).returnDate(LocalDate.now().plusDays(7)).build();
        tourRepository.save(tour2);
        //When
        List<Tour> tours = tourRepository.findAll();
        //Then
        assertEquals(2, tours.size());
        //CleanUp
        tourRepository.deleteAll();
    }

    @Test
    void deleteTourById() {
        //Given
        tourRepository.save(tour);
        //When
        tourRepository.deleteById(tour.getTourId());
        //Then
        assertEquals(0, tourRepository.findAll().size());
    }
}