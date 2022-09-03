package com.backend.holydaystravel.facade;

import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.dto.TourDto;
import com.backend.holydaystravel.exception.TourNotFoundException;
import com.backend.holydaystravel.mapper.TourMapper;
import com.backend.holydaystravel.service.TourDbService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TourFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(TourFacade.class);
    private final TourDbService dbService;
    private final TourMapper mapper;

    public List<TourDto> getAllTours() {
        LOGGER.info("Starting searching all tours...");
        List<Tour> tours = dbService.getAllTours();
        LOGGER.info("All tours have been fetched. Currently amount of tours: " + tours.size());
        return mapper.mapToTourDtoList(tours);
    }
    public TourDto getTour(final Long tourId) throws TourNotFoundException {
        LOGGER.info("Starting searching the tour...");
        Tour tour = dbService.getTour(tourId);
        LOGGER.info("The tour has been fetched.");
        return mapper.mapToTourDto(tour);
    }
    public void createTour(final TourDto tourDto) {
        Tour tour = mapper.mapToTour(tourDto);
        LOGGER.info("Starting creating the tour...");
        dbService.saveTour(tour);
        LOGGER.info("The tour has been created.");
    }
    public void deleteTour(final Long tourId) throws TourNotFoundException {
        LOGGER.info("Starting deleting the tour...");
        dbService.deleteTour(tourId);
        LOGGER.info("The tour has been deleted.");
    }
    public TourDto updateTour(final TourDto tourDto) throws TourNotFoundException {
        Tour tour = mapper.mapToTour(tourDto);
        LOGGER.info("Starting updating the tour...");
        dbService.saveTour(tour);
        LOGGER.info("The tour has been updated.");
        return mapper.mapToTourDto(tour);
    }
}
