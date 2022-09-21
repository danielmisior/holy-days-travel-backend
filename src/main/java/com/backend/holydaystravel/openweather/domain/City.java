package com.backend.holydaystravel.openweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private long id;
    private String name;
    private String country;
    private long population;
    private long timezone;
    private long sunrise;
    private long sunset;
}
