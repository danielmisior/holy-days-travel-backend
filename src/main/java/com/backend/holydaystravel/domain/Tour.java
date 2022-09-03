package com.backend.holydaystravel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity(name = "TOURS")
@AllArgsConstructor
@NoArgsConstructor
public final class Tour {

    @Id
    @Column(name = "TOUR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tourId;

    @Column(name = "TOUR_PRICE")
    private Double tourPrice;

    @Column(name = "INITIATORY_PLACE")
    private String initiatoryPlace;

    @Column(name = "DESTINATION_PLACE")
    private String destinationPlace;

    @Column(name = "DEPARTURE_DATE")
    private LocalDate departureDate;
}