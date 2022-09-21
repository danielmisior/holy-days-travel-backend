package com.backend.holydaystravel.config;

import com.backend.holydaystravel.openweather.config.OpenWeatherConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class OpenWeatherConfigTest {
    private OpenWeatherConfiguration config;

    @Test
    void gettersShouldBeNull() {
        //Given
        config = new OpenWeatherConfiguration();
        //When
        String endpoint = config.getOpenWeatherApiEndpoint();
        String apiKey = config.getOpenWeatherApiKey();
        //Then
        assertNull(endpoint);
        assertNull(apiKey);
    }
}
