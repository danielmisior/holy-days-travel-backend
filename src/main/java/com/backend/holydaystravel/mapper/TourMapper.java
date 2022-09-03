package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.dto.TourDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourMapper {

    public Tour mapToTour(final TourDto tourDto) {
        return new Tour(
                tourDto.getTourId(),
                tourDto.getTourPrice(),
                tourDto.getInitiatoryPlace(),
                tourDto.getDestinationPlace(),
                tourDto.getDepartureDate()
        );
    }
    public TourDto mapToTourDto(final Tour tour) {
        return new TourDto(
                tour.getTourId(),
                tour.getTourPrice(),
                tour.getInitiatoryPlace(),
                tour.getDestinationPlace(),
                tour.getDepartureDate()
        );
    }
    public List<TourDto> mapToTourDtoList(final List<Tour> tours) {
        return tours.stream()
                .map(this::mapToTourDto)
                .collect(Collectors.toList());
    }
}
