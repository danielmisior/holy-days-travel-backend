package com.backend.holydaystravel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Tour {

    private Long tourId;
    private Double tourPrice;
    private String initiatoryPlace;
    private String destinationPlace;
    private LocalDate departureDate;
}
