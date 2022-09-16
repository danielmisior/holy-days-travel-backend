package com.backend.holydaystravel.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long flightId;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime scheduledDeparture;
    private LocalDateTime scheduledReturn;
}
