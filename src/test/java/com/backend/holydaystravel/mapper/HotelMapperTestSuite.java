package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.domain.dto.HotelDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HotelMapperTestSuite {
    private HotelMapper mapper;
    private Hotel hotel;
    private HotelDto hotelDto;

    @BeforeEach
    void initTests() {
        mapper = new HotelMapper();
        hotel = Hotel.builder().hotelId(1L).hotelName("name").country("country")
                .address("address").stars(5).pricePerNight(30.99).nightsNumber(5)
                .build();
        hotelDto = new HotelDto(1L, "name", "country", "address", 5, 30.99, 5);
    }

    @Test
    void mapToHotelTest() {
        //Given&When
        Hotel result = mapper.mapToHotel(hotelDto);
        //Then
        assertEquals(1L, result.getHotelId());
        assertEquals("address", result.getAddress());
        assertEquals(5, result.getStars());
    }

    @Test
    void mapToHotelDtoTest() {
        //Given&Then
        HotelDto result = mapper.mapToHotelDto(hotel);
        //Then
        assertEquals(30.99, result.getPricePerNight());
        assertEquals(5, result.getNightsNumber());
    }

    @Test
    void mapToHotelDtoListTest() {
        //Given
        List<Hotel> hotels = List.of(hotel);
        //When
        List<HotelDto> resultList = mapper.mapToHotelListDto(hotels);
        //Then
        assertEquals(1, resultList.size());
        assertEquals("name", resultList.get(0).getHotelName());
        assertEquals("country", resultList.get(0).getCountry());
    }
}
