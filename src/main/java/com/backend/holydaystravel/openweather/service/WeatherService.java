package com.backend.holydaystravel.openweather.service;

import com.backend.holydaystravel.openweather.client.OpenWeatherClient;
import com.backend.holydaystravel.openweather.dto.WeatherDto;
import com.backend.holydaystravel.openweather.dto.WeatherForecastDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherClient client;

    public WeatherDto getActualWeather(String cityName) {
        return client.getActualWeather(cityName);
    }

    public WeatherForecastDto get5DayWeatherForecast(String cityName) {
        return client.getWeatherForecast(cityName);
    }
    public double calculate5DayAverageTemp(String cityName) {
        WeatherForecastDto forecastDto = get5DayWeatherForecast(cityName);
        OptionalDouble average = forecastDto.getList().stream()
                .map(m -> m.getMain())
                .mapToDouble(t -> t.getTemp())
                .average();
        return average.getAsDouble();
    }
}
