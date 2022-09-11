package com.backend.holydaystravel.mapper;

import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.domain.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelMapper {
    public Hotel mapToHotel(final HotelDto hotelDto) {
        return Hotel.builder()
                .hotelId(hotelDto.getHotelId())
                .hotelName(hotelDto.getHotelName())
                .country(hotelDto.getCountry())
                .address(hotelDto.getAddress())
                .stars(hotelDto.getStars())
                .pricePerNight(hotelDto.getPricePerNight())
                .nightsNumber(hotelDto.getNightsNumber())
                .build();
    }
    public HotelDto mapToHotelDto(final Hotel hotel) {
        return new HotelDto(
                hotel.getHotelId(),
                hotel.getHotelName(),
                hotel.getCountry(),
                hotel.getAddress(),
                hotel.getStars(),
                hotel.getPricePerNight(),
                hotel.getNightsNumber()
        );
    }
    public List<HotelDto> mapToHotelListDto(final List<Hotel> hotels) {
        return hotels.stream()
                .map(this::mapToHotelDto)
                .collect(Collectors.toList());
    }
}
