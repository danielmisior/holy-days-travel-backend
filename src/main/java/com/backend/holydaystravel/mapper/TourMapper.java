package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.domain.dto.TourDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourMapper {

    public Tour mapToTour(final TourDto tourDto) {
        return Tour.builder()
                .tourId(tourDto.getTourId())
                .tourPrice(tourDto.getTourPrice())
                .initiatoryPlace(tourDto.getInitiatoryPlace())
                .destinationPlace(tourDto.getDestinationPlace())
                .departureDate(tourDto.getDepartureDate())
                .returnDate(tourDto.getReturnDate())
                .build();
    }
    public TourDto mapToTourDto(final Tour tour) {
        return new TourDto(
                tour.getTourId(),
                tour.getTourPrice(),
                tour.getInitiatoryPlace(),
                tour.getDestinationPlace(),
                tour.getDepartureDate(),
                tour.getReturnDate()
        );
    }
    public List<TourDto> mapToTourDtoList(final List<Tour> tours) {
        return tours.stream()
                .map(this::mapToTourDto)
                .collect(Collectors.toList());
    }
}
