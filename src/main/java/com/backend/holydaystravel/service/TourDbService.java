package com.backend.holydaystravel.service;

import com.backend.holydaystravel.domain.Tour;
import com.backend.holydaystravel.exception.TourNotFoundException;
import com.backend.holydaystravel.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourDbService {
    private final TourRepository tourRepository;

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }
    public Tour getTour(final Long tourId) throws TourNotFoundException {
        return tourRepository.findById(tourId).orElseThrow(TourNotFoundException::new);
    }
    public Tour saveTour(final Tour tour) {
        return tourRepository.save(tour);
    }
    public void deleteTour(final Long tourId) throws TourNotFoundException {
        Tour searchedTour = tourRepository.findById(tourId).orElseThrow(TourNotFoundException::new);
        tourRepository.delete(searchedTour);
    }
}