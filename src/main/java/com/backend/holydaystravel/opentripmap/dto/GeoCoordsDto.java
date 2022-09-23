package com.backend.holydaystravel.opentripmap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoCoordsDto {
    private String name;
    private String country;
    private double lat;
    private double lon;
    private int population;
    private String timezone;
}
