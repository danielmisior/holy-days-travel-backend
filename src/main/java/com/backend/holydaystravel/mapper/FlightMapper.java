package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightMapper {
    public Flight mapToFlight(final FlightDto flightDto) {
        return Flight.builder()
                .flightId(flightDto.getFlightId())
                .departureAirport(flightDto.getDepartureAirport())
                .arrivalAirport(flightDto.getArrivalAirport())
                .scheduledDeparture(flightDto.getScheduledDeparture())
                .scheduledReturn(flightDto.getScheduledReturn())
                .build();
    }
    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getFlightId(),
                flight.getDepartureAirport(),
                flight.getArrivalAirport(),
                flight.getScheduledDeparture(),
                flight.getScheduledReturn()
        );
    }
    public List<FlightDto> mapToFlightDtoList(final List<Flight> flights) {
        return flights.stream()
                .map(this::mapToFlightDto)
                .collect(Collectors.toList());
    }
}
