package com.backend.holydaystravel.facade;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.dto.FlightDto;
import com.backend.holydaystravel.exception.FlightNotFoundException;
import com.backend.holydaystravel.mapper.FlightMapper;
import com.backend.holydaystravel.service.FlightDbService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightFacade.class);
    private final FlightDbService service;
    private final FlightMapper mapper;

    public List<FlightDto> getAllFlights() {
        LOGGER.info("Starting searching all flights...");
        List<Flight> flights = service.getAllFlights();
        LOGGER.info("All flights have been fetched. Currently amount of flights: " + flights.size());
        return mapper.mapToFlightDtoList(flights);
    }
    public FlightDto getFlight(final Long flightId) throws FlightNotFoundException {
        LOGGER.info("Starting searching the flight...");
        Flight flight = service.getFlight(flightId);
        LOGGER.info("The flight has been fetched.");
        return mapper.mapToFlightDto(flight);
    }
    public void createFlight(final FlightDto flightDto) {
        Flight flight = mapper.mapToFlight(flightDto);
        LOGGER.info("Starting creating the flight...");
        service.saveFlight(flight);
        LOGGER.info("The flight has been created.");
    }
    public void deleteFlight(final Long flightId) throws FlightNotFoundException {
        LOGGER.info("Starting deleting the flight...");
        service.deleteFlight(flightId);
        LOGGER.info("The flight has been deleted.");
    }
    public FlightDto updateFlight(final FlightDto flightDto) throws FlightNotFoundException {
        Flight flight = mapper.mapToFlight(flightDto);
        LOGGER.info("Starting updating the flight...");
        Flight updatedFlight = service.updateFlight(flight);
        LOGGER.info("The flight has been updated.");
        return mapper.mapToFlightDto(updatedFlight);
    }
}
