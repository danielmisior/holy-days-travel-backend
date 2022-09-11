package com.backend.holydaystravel.repository;

import com.backend.holydaystravel.domain.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
                .nightsNumber(3)
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
}
