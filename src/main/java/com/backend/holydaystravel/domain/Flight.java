package com.backend.holydaystravel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity(name = "FLIGHTS")
@AllArgsConstructor
@NoArgsConstructor
public final class Flight {
    @Id
    @Column(name = "FLIGHT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long flightId;

    @Column(name = "DEPARTURE_AIRPORT")
    private String departureAirport;

    @Column(name = "ARRIVAL_AIRPORT")
    private String arrivalAirport;

    @Column(name = "SCHEDULED_DEPARTURE")
    private LocalDateTime scheduledDeparture;

    @Column(name = "SCHEDULED_RETURN")
    private LocalDateTime scheduledReturn;

    @OneToOne(mappedBy = "flight")
    private Tour tour;
}
