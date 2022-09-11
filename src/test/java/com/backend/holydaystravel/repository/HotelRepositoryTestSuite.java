package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HotelRepositoryTestSuite {
    @Autowired
    private HotelRepository hotelRepository;
    private Hotel hotel;

    @BeforeEach
    public void initTests() {
        hotel = Hotel.builder()
                .hotelName("hotel")
                .country("country")
                .address("address")
                .stars(5)
                .pricePerNight(39.99)
                .nightsNumber(5)
                .build();
    }

    @Test
    public void safeHotel() {
        //Given&When
        hotelRepository.save(hotel);
        boolean exist = hotelRepository.existsById(hotel.getHotelId());
        Long hotelId = hotelRepository.findById(hotel.getHotelId()).get().getHotelId();
        //Then
        assertTrue(exist);
        assertEquals("country", hotelRepository.findById(hotelId).get().getCountry());
        assertEquals(5, hotelRepository.findById(hotelId).get().getStars());
        //CleanUp
        hotelRepository.deleteById(hotelId);
    }

    @Test
    public void findHotelById() {
        //Given
        hotelRepository.save(hotel);
        //When
        Hotel result = hotelRepository.findById(hotel.getHotelId()).get();
        //Then
        assertEquals("hotel", result.getHotelName());
        assertEquals(39.99, result.getPricePerNight());
        //CleanUp
        hotelRepository.deleteAll();
    }

    @Test
    public void findAllHotels() {
        //Given
        Hotel hotel2 = Hotel.builder().hotelName("test").pricePerNight(20.00).nightsNumber(3)
                .address("test").country("test").stars(3).build();
        hotelRepository.save(hotel);
        hotelRepository.save(hotel2);
        //When
        List<Hotel> hotels = hotelRepository.findAll();
        //Then
        assertEquals(2, hotels.size());
        //CleanUp
        hotelRepository.deleteAll();
    }

    @Test
    public void deleteHotelById() {
        //Given
        hotelRepository.save(hotel);
        //When
        hotelRepository.deleteById(hotel.getHotelId());
        //Then
        assertEquals(0, hotelRepository.findAll().size());
    }
}
