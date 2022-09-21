package com.backend.holydaystravel.client;

import com.backend.holydaystravel.openweather.client.OpenWeatherClient;
import com.backend.holydaystravel.openweather.config.OpenWeatherConfiguration;
import com.backend.holydaystravel.openweather.domain.City;
import com.backend.holydaystravel.openweather.domain.dto.WeatherForecastDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenWeatherClientTest {
    @InjectMocks
    private OpenWeatherClient client;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private OpenWeatherConfiguration config;

    @Test
    void shouldFetchWeatherForecast() throws URISyntaxException {
        //Given
        when(config.getOpenWeatherApiEndpoint()).thenReturn("http://test.com/forecast");
        when(config.getOpenWeatherApiKey()).thenReturn("1234");

        WeatherForecastDto forecastDto = new WeatherForecastDto(new ArrayList<>(), new City());

        URI uri = new URI("http://test.com/forecast?q=test&lang=pl&units=metric&appid=1234");

        when(restTemplate.getForObject(uri, WeatherForecastDto.class)).thenReturn(forecastDto);

        //When
        WeatherForecastDto result = client.getWeatherForecast("test");

        //Then
        assertEquals(new ArrayList<>(), result.getList());
        assertNotNull(result.getCity());
    }
}
