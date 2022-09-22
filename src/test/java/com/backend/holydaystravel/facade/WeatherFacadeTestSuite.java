package com.backend.holydaystravel.facade;


import com.backend.holydaystravel.openweather.domain.*;
import com.backend.holydaystravel.openweather.domain.dto.WeatherDto;
import com.backend.holydaystravel.openweather.domain.dto.WeatherForecastDto;
import com.backend.holydaystravel.openweather.facade.WeatherFacade;
import com.backend.holydaystravel.openweather.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherFacadeTestSuite {
    @InjectMocks
    private WeatherFacade facade;
    @Mock
    private WeatherService service;
    WeatherForecastDto forecastDto;
    WeatherDto weatherDto;

    @Test
    void getWeatherForecastTest() {
        //Given
        ArrayList<List> list = new ArrayList();
        City city = new City();
        forecastDto = new WeatherForecastDto(list, city);

        when(service.get5DayWeatherForecast("city")).thenReturn(forecastDto);

        //When
        WeatherForecastDto result = facade.fetch5DayWeatherForecast("city");

        //Then
        assertNotNull(result);
        assertNotNull(result.getCity());
        assertEquals(new ArrayList<>(), result.getList());
    }

    @Test
    void get5DayAverageTempTest() {
        //Given
        Main main1 = new Main(22.0, 21.5, 20.0, 22.5, 123, 123, 123, 123);
        Main main2 = new Main(20.5, 19.5, 19.5, 21.0, 321, 321, 321, 321);
        List list1 = new List(main1, new ArrayList<>(), new Clouds(), new Wind(), 23);
        List list2 = new List(main2, new ArrayList<>(), new Clouds(), new Wind(), 15);
        java.util.List<List> lists = java.util.List.of(list1, list2);

        double average = (lists.get(0).getMain().getTemp() + lists.get(1).getMain().getTemp())/2;

        when(service.calculate5DayAverageTemp("city")).thenReturn(average);

        //When
        Double result = facade.get5DayAverageTemp("city");

        //Then
        assertEquals(21.25, result);
    }

    @Test
    void getActualWeatherTest() {
        //Given
        weatherDto = new WeatherDto(new ArrayList<>(), new Main(), 123,  new Wind(), new Clouds());

        when(service.getActualWeather("city")).thenReturn(weatherDto);

        //When
        WeatherDto result = facade.fetchActualWeather("city");

        //Then
        assertNotNull(result);
        assertNotNull(result.getMain());
        assertEquals(new ArrayList<>(), result.getWeather());
    }
}
