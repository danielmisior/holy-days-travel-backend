package com.backend.holydaystravel.openweather.domain.dto;

import com.backend.holydaystravel.openweather.domain.City;
import com.backend.holydaystravel.openweather.domain.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDto {
    @JsonProperty("list")
    private ArrayList<List> list;
    @JsonProperty("city")
    private City city;
}
