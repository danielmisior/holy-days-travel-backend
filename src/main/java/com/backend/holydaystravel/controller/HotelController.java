package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.domain.dto.HotelDto;
import com.backend.holydaystravel.exception.HotelNotFoundException;
import com.backend.holydaystravel.facade.HotelFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/hotel")
public class HotelController {
    private final HotelFacade hotelFacade;

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(hotelFacade.getAllHotels());
    }

    @GetMapping(value = "{hotelId}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable Long hotelId) throws HotelNotFoundException {
        return ResponseEntity.ok(hotelFacade.getHotel(hotelId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createHotel(@RequestBody HotelDto hotelDto) {
        hotelFacade.createHotel(hotelDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long hotelId) throws HotelNotFoundException {
        hotelFacade.deleteHotel(hotelId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelDto hotelDto) throws HotelNotFoundException {
        return ResponseEntity.ok(hotelFacade.updateHotel(hotelDto));
    }
}