package com.backend.holydaystravel.client;

import com.backend.holydaystravel.openweather.client.OpenWeatherClient;
import com.backend.holydaystravel.openweather.config.OpenWeatherConfiguration;
import com.backend.holydaystravel.openweather.domain.City;
import com.backend.holydaystravel.openweather.domain.Clouds;
import com.backend.holydaystravel.openweather.domain.Main;
import com.backend.holydaystravel.openweather.domain.Wind;
import com.backend.holydaystravel.openweather.domain.dto.WeatherDto;
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
        when(config.getOpenWeatherApiEndpoint()).thenReturn("http://test.com");
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

    @Test
    void shouldFetchActualWeather() throws URISyntaxException {
        //Given
        when(config.getOpenWeatherApiEndpoint()).thenReturn("http://test.com");
        when(config.getOpenWeatherApiKey()).thenReturn("1234");

        WeatherDto weatherDto = new WeatherDto(new ArrayList<>(), new Main(), 123, new Wind(), new Clouds());

        URI uri = new URI("http://test.com/weather?q=test&lang=pl&units=metric&appid=1234");

        when(restTemplate.getForObject(uri, WeatherDto.class)).thenReturn(weatherDto);

        //When
        WeatherDto result = client.getActualWeather("test");

        //Then
        assertNotNull(result.getMain());
        assertEquals(123, result.getVisibility());
        assertEquals(new ArrayList<>(), result.getWeather());
    }
}
