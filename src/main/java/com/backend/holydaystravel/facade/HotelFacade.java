package com.backend.holydaystravel.facade;

import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.domain.dto.HotelDto;
import com.backend.holydaystravel.exception.HotelNotFoundException;
import com.backend.holydaystravel.mapper.HotelMapper;
import com.backend.holydaystravel.service.HotelDbService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelFacade.class);
    private final HotelDbService service;
    private final HotelMapper mapper;

    public List<HotelDto> getAllHotels() {
        LOGGER.info("Starting searching all hotels...");
        List<Hotel> hotels = service.getAllHotels();
        LOGGER.info("All hotels have been fetched. Currently amount of hotels: " + hotels.size());
        return mapper.mapToHotelListDto(hotels);
    }
    public HotelDto getHotel(final Long hotelId) throws HotelNotFoundException {
        LOGGER.info("Starting searching the hotel...");
        Hotel hotel = service.getHotel(hotelId);
        LOGGER.info("The hotel has been fetched.");
        return mapper.mapToHotelDto(hotel);
    }
    public void createHotel(final HotelDto hotelDto) {
        Hotel hotel = mapper.mapToHotel(hotelDto);
        LOGGER.info("Starting creating the hotel...");
        service.saveHotel(hotel);
        LOGGER.info("The hotel has been created.");
    }
    public void deleteHotel(final Long hotelId) throws HotelNotFoundException {
        LOGGER.info("Starting deleting the hotel...");
        service.deleteHotel(hotelId);
        LOGGER.info("The hotel has been deleted.");
    }
    public HotelDto updateHotel(final HotelDto hotelDto) throws HotelNotFoundException {
        Hotel hotel = mapper.mapToHotel(hotelDto);
        LOGGER.info("Starting updating the hotel...");
        Hotel updatedHotel = service.updateHotel(hotel);
        LOGGER.info("The hotel has been updated.");
        return mapper.mapToHotelDto(updatedHotel);
    }
}
