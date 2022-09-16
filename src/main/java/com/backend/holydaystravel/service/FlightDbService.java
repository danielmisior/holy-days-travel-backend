package com.backend.holydaystravel.service;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.exception.FlightNotFoundException;
import com.backend.holydaystravel.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightDbService {
    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Flight getFlight(final Long flightId) throws FlightNotFoundException {
        return flightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
    }
    public Flight saveFlight(final Flight flight) {
        return flightRepository.save(flight);
    }
    public void deleteFlight(final Long flightId) throws FlightNotFoundException {
        Flight searchedFlight = flightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
        flightRepository.delete(searchedFlight);
    }
    public Flight updateFlight(final Flight flight) throws FlightNotFoundException {
        flightRepository.findById(flight.getFlightId()).orElseThrow(FlightNotFoundException::new);
        return saveFlight(flight);
    }
}
