package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.openweather.dto.WeatherDto;
import com.backend.holydaystravel.openweather.dto.WeatherForecastDto;
import com.backend.holydaystravel.openweather.facade.WeatherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/weather")
public class WeatherController {
    private final WeatherFacade facade;

    @GetMapping(value = "{cityName}")
    public ResponseEntity<WeatherDto> getActualWeather(@PathVariable String cityName) {
        return ResponseEntity.ok(facade.fetchActualWeather(cityName));
    }

    @GetMapping( "forecast/{cityName}")
    public ResponseEntity<WeatherForecastDto> get5DayWeatherForecast(@PathVariable String cityName) {
        return ResponseEntity.ok(facade.fetch5DayWeatherForecast(cityName));
    }

    @GetMapping("forecast/{cityName}/average_temp")
    public ResponseEntity<Double> get5DayAverageTemperature(@PathVariable String cityName) {
        return ResponseEntity.ok(facade.get5DayAverageTemp(cityName));
    }
}
