package com.backend.holydaystravel.openweather.client;

import com.backend.holydaystravel.openweather.config.OpenWeatherConfiguration;
import com.backend.holydaystravel.openweather.domain.dto.WeatherForecastDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class OpenWeatherClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherClient.class);
    private final RestTemplate restTemplate;
    private final OpenWeatherConfiguration config;

    private URI makeURL(String cityName) {
        return UriComponentsBuilder
                .fromHttpUrl(config.getOpenWeatherApiEndpoint())
                .queryParam("q", cityName)
                .queryParam("lang", "pl")
                .queryParam("units", "metric")
                .queryParam("appid", config.getOpenWeatherApiKey())
                .build()
                .encode()
                .toUri();
    }

    public WeatherForecastDto getWeatherForecast(String cityName) {
        try {
            return restTemplate.getForObject(makeURL(cityName), WeatherForecastDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
