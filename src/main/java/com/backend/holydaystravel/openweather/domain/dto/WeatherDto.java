package com.backend.holydaystravel.openweather.domain.dto;

import com.backend.holydaystravel.openweather.domain.Clouds;
import com.backend.holydaystravel.openweather.domain.Main;
import com.backend.holydaystravel.openweather.domain.Weather;
import com.backend.holydaystravel.openweather.domain.Wind;
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
public class WeatherDto {
    @JsonProperty("weather")
    private ArrayList<Weather> weather;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Clouds clouds;
}
