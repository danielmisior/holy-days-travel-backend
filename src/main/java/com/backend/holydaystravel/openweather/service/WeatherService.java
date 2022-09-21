package com.backend.holydaystravel.openweather.service;

import com.backend.holydaystravel.openweather.client.OpenWeatherClient;
import com.backend.holydaystravel.openweather.domain.dto.WeatherForecastDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherClient client;

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
