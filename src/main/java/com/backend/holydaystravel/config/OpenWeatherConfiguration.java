package com.backend.holydaystravel.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class OpenWeatherConfiguration {

    @Value("${open.weather.api.endpoint}")
    private String openWeatherApiEndpoint;

    @Value("${open.weather.api.key}")
    private String openWeatherApiKey;
}
