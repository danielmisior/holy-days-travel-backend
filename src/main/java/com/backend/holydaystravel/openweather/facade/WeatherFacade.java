package com.backend.holydaystravel.openweather.facade;

import com.backend.holydaystravel.openweather.dto.WeatherDto;
import com.backend.holydaystravel.openweather.dto.WeatherForecastDto;
import com.backend.holydaystravel.openweather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherFacade.class);
    private final WeatherService service;

    public WeatherDto fetchActualWeather(String cityName) {
        LOGGER.info("Starting sending request to Open Weather...");
        WeatherDto weatherDto = service.getActualWeather(cityName);
        LOGGER.info("The actual weather for " + cityName + " has been fetched.");
        return weatherDto;
    }

    public WeatherForecastDto fetch5DayWeatherForecast(String cityName) {
        LOGGER.info("Starting sending request to Open Weather...");
        WeatherForecastDto forecastDto = service.get5DayWeatherForecast(cityName);
        LOGGER.info("The 5 day weather forecast for " + cityName + " has been fetched.");
        return forecastDto;
    }
    public double get5DayAverageTemp(String cityName) {
        LOGGER.info("Starting calculating 5 day average temperature for " + cityName + "...");
        double average = service.calculate5DayAverageTemp(cityName);
        LOGGER.info("The average has been calculated.");
        return average;
    }
}
