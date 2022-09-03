package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.dto.TourDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TourMapperTestSuite {
    private TourMapper tourMapper;
    private TourDto tourDto;
    private Tour tour;

    @BeforeEach
    void initTest() {
        tourMapper = new TourMapper();
        tourDto = TourDto.builder()
                .tourPrice(1999.99)
                .initiatoryPlace("Wroclaw")
                .destinationPlace("Majorca")
                .departureDate(LocalDate.of(2022, 12, 15))
                .build();
        tour = Tour.builder()
                .tourPrice(2999.99)
                .initiatoryPlace("Warsaw")
                .destinationPlace("Crete")
                .departureDate(LocalDate.of(2023, 01, 05))
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
        assertEquals(2999.99, resultTourDto.getTourPrice());
        assertEquals("Warsaw", resultTourDto.getInitiatoryPlace());
        assertEquals( "Crete", resultTourDto.getDestinationPlace());
        assertEquals(LocalDate.of(2023, 01, 05), resultTourDto.getDepartureDate());
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
