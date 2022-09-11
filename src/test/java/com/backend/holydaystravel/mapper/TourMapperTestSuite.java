package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.domain.dto.TourDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TourMapperTestSuite {
    private TourMapper tourMapper;
    private Tour tour;
    private TourDto tourDto;

    @BeforeEach
    void initTest() {
        tourMapper = new TourMapper();
        Hotel hotel = new Hotel(1L, "hotel", "country",
                "address", 5, 38.99, 3, new ArrayList<>());
        Flight flight = new Flight(1L, "departure airport",
                "arrival airport", LocalDateTime.now(), LocalDateTime.now().plusDays(7), tour);
        tourDto = new TourDto(1L, 1999.99, "Wroclaw",
                "Majorca", LocalDate.of(2022, 12, 15),
                LocalDate.of(2022, 12, 22));
        tour = Tour.builder()
                .tourPrice(2999.99)
                .initiatoryPlace("Warsaw")
                .destinationPlace("Crete")
                .departureDate(LocalDate.of(2023, 1, 5))
                .returnDate(LocalDate.of(2023, 1, 12))
                .hotel(hotel)
                .flight(flight)
                .build();
    }

    @Test
    void mapToTourTest() {
        //Given&When
        Tour resultTour = tourMapper.mapToTour(tourDto);
        //Then
        assertEquals(1999.99, resultTour.getTourPrice());
        assertEquals("Wroclaw", resultTour.getInitiatoryPlace());
        assertEquals("Majorca", resultTour.getDestinationPlace());
        assertEquals(LocalDate.of(2022, 12, 15), resultTour.getDepartureDate());
    }
    @Test
    void mapToTourDtoTest() {
        //Given&When
        TourDto resultTourDto = tourMapper.mapToTourDto(tour);
        //Then
        assertEquals("Warsaw", resultTourDto.getInitiatoryPlace());
    }
    @Test
    void mapToTourDtoList() {
        //Given
        List<Tour> tourList = List.of(tour);
        //When
        List<TourDto> tourDtoList = tourMapper.mapToTourDtoList(tourList);
        //Then
        assertEquals(1, tourDtoList.size());
        assertEquals("Warsaw", tourDtoList.get(0).getInitiatoryPlace());
    }
}
