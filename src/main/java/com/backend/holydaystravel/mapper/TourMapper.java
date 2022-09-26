package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Flight;
import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.domain.dto.TourDto;
import com.backend.holydaystravel.exception.FlightNotFoundException;
import com.backend.holydaystravel.exception.HotelNotFoundException;
import com.backend.holydaystravel.service.FlightDbService;
import com.backend.holydaystravel.service.HotelDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourMapper {
    private final FlightDbService flightService;
    private final HotelDbService hotelService;

    public Tour mapToTour(final TourDto tourDto) throws FlightNotFoundException, HotelNotFoundException {
        return Tour.builder()
                .tourId(tourDto.getTourId())
                .tourPrice(tourDto.getTourPrice())
                .initiatoryPlace(tourDto.getInitiatoryPlace())
                .destinationPlace(tourDto.getDestinationPlace())
                .departureDate(tourDto.getDepartureDate())
                .returnDate(tourDto.getReturnDate())
                .flight(flightService.getFlight(tourDto.getFlightId()))
                .hotel(hotelService.getHotel(tourDto.getHotelId()))
                .build();
    }
    public TourDto mapToTourDto(final Tour tour) {
        return new TourDto(
                tour.getTourId(),
                tour.getTourPrice(),
                tour.getInitiatoryPlace(),
                tour.getDestinationPlace(),
                tour.getDepartureDate(),
                tour.getReturnDate(),
                tour.getFlight().getFlightId(),
                tour.getHotel().getHotelId()
        );
    }
    public List<TourDto> mapToTourDtoList(final List<Tour> tours) {
        return tours.stream()
                .map(this::mapToTourDto)
                .collect(Collectors.toList());
    }
}
