package com.backend.holydaystravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TourDto {

    private Long tourId;
    private Double tourPrice;
    private String initiatoryPlace;
    private String destinationPlace;
    private LocalDate departureDate;
}
