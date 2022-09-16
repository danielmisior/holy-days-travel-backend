package com.backend.holydaystravel.service;

import com.backend.holydaystravel.domain.Hotel;
import com.backend.holydaystravel.exception.HotelNotFoundException;
import com.backend.holydaystravel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelDbService {
    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    public Hotel getHotel(final Long hotelId) throws HotelNotFoundException {
        return hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
    }
    public Hotel saveHotel(final Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    public void deleteHotel(final Long hotelId) throws HotelNotFoundException {
        Hotel searchedHotel = hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
        hotelRepository.delete(searchedHotel);
    }
    public Hotel updateHotel(final Hotel hotel) throws HotelNotFoundException {
        hotelRepository.findById(hotel.getHotelId()).orElseThrow(HotelNotFoundException::new);
        return hotelRepository.save(hotel);
    }
}
