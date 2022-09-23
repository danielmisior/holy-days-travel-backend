package com.backend.holydaystravel.openweather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private String name;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;
}
