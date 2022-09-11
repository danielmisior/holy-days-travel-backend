package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FlightRepositoryTestSuite {
    @Autowired
    private FlightRepository flightRepository;
    private Flight flight;

    @BeforeEach
    public void initTests() {
        flight = Flight.builder().departureAirport("test").arrivalAirport("test")
                .scheduledDeparture(LocalDateTime.of(2022, 10, 15, 16, 30))
                .scheduledReturn(LocalDateTime.of(2022, 10, 15, 19, 00)).build();
    }

    @Test
    public void saveFlightTest() {
        //Given&When
        flightRepository.save(flight);
        //Then
        assertTrue(flightRepository.existsById(flight.getFlightId()));
        assertEquals("test", flight.getDepartureAirport());
        //CleanUp
        flightRepository.deleteAll();
    }

    @Test
    public void findFlightById() {
        //Given
        flightRepository.save(flight);
        LocalDateTime departureDate = LocalDateTime.of(2022, 10, 15, 16, 30);
        //When
        Flight result = flightRepository.findById(flight.getFlightId()).get();
        //Then
        assertEquals("test", result.getArrivalAirport());
        assertEquals(departureDate, result.getScheduledDeparture());
        //CleanUp
        flightRepository.deleteAll();
    }

    @Test
    public void deleteFlightById() {
        //Given
        flightRepository.save(flight);
        LocalDateTime scheduledReturn = LocalDateTime.of(2022, 10, 15, 19, 00);
        //When
        Flight result = flightRepository.findById(flight.getFlightId()).get();
        //Then
        assertEquals(scheduledReturn, result.getScheduledReturn());
        assertEquals("test", result.getDepartureAirport());
    }
}