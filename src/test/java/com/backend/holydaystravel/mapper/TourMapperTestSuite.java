package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.domain.dto.TourDto;
import com.backend.holydaystravel.service.FlightDbService;
import com.backend.holydaystravel.service.HotelDbService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TourMapperTestSuite {
    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private FlightDbService flightService;

    @Autowired
    private HotelDbService hotelService;

    private Tour tour;
    private TourDto tourDto;
    private Flight flight;
    private Hotel hotel;

    @BeforeEach
    void initTest() {
        hotel = Hotel.builder().hotelName("name").country("country").address("address")
                .stars(5).pricePerNight(30.99).nightsNumber(5).build();
        flight = Flight.builder().departureAirport("test").arrivalAirport("test")
                .scheduledDeparture(LocalDateTime.now()).scheduledReturn(LocalDateTime.now().plusDays(5)).build();

        flightService.saveFlight(flight);
        hotelService.saveHotel(hotel);

        tour = Tour.builder()
                .tourPrice(2999.99)
                .initiatoryPlace("Warsaw")
                .destinationPlace("Crete")
                .departureDate(LocalDate.of(2023, 1, 5))
                .returnDate(LocalDate.of(2023, 1, 12))
                .hotel(hotel)
                .flight(flight)
                .build();
        tourDto = new TourDto(1L, 1999.99, "Wroclaw",
                "Majorca", LocalDate.of(2022, 12, 15),
                LocalDate.of(2022, 12, 22), flight.getFlightId(), hotel.getHotelId());
    }

    @AfterEach
    void afterEveryTest() {
        flightService.deleteFlight(flight.getFlightId());
        hotelService.deleteHotel(hotel.getHotelId());
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
