package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.dto.FlightDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FlightMapperTestSuite {
    private FlightMapper mapper;
    private Flight flight;
    private FlightDto flightDto;

    @BeforeEach
    void initTests() {
        mapper = new FlightMapper();
        flight = Flight.builder().flightId(1L).departureAirport("test").arrivalAirport("test")
                .scheduledDeparture(LocalDateTime.of(2022, 10, 15, 14, 30))
                .scheduledReturn(LocalDateTime.of(2022, 10, 20, 14, 30))
                .build();
        flightDto = new FlightDto(1L, "test", "test",
                LocalDateTime.of(2022, 10, 15, 14, 30),
                LocalDateTime.of(2022, 10, 20, 14, 30));
    }

    @Test
    void mapToFlightTest() {
        //Given&When
        Flight result = mapper.mapToFlight(flightDto);
        //Then
        assertEquals("test", result.getDepartureAirport());
        assertEquals(1L, result.getFlightId());
        assertEquals(LocalDateTime.of(2022, 10, 15, 14, 30), result.getScheduledDeparture());
    }

    @Test
    void mapToFlightDtoTest() {
        //Given&When
        FlightDto result = mapper.mapToFlightDto(flight);
        //Then
        assertEquals("test", result.getArrivalAirport());
        assertEquals(1L, result.getFlightId());
        assertEquals(LocalDateTime.of(2022, 10, 20, 14, 30), result.getScheduledReturn());
    }

    @Test
    void mapToFlightDtoListTest() {
        //Given
        List<Flight> flights = List.of(flight);
        //When
        List<FlightDto> resultList = mapper.mapToFlightDtoList(flights);
        //Then
        assertEquals(1, resultList.size());
        assertEquals("test", resultList.get(0).getArrivalAirport());
    }
}
