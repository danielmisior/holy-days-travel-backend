package com.backend.holydaystravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TourDto {

    private Long tourId;
    private Double tourPrice;
    private String initiatoryPlace;
    private String destinationPlace;
    private LocalDate departureDate;
}
