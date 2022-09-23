package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.opentripmap.dto.GeoCoordsDto;
import com.backend.holydaystravel.opentripmap.dto.PlaceListDto;
import com.backend.holydaystravel.opentripmap.dto.PlacePropertiesDto;
import com.backend.holydaystravel.opentripmap.service.OpenTripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/places")
public class OpenTripController {
    private final OpenTripService service;

    @GetMapping("coords")
    public ResponseEntity<GeoCoordsDto> getCoordinates(@RequestParam String placeName) {
        return ResponseEntity.ok(service.getCoordinates(placeName));
    }

    @GetMapping("list")
    public ResponseEntity<List<PlaceListDto>> getPlaceList(@RequestParam int radius,
                                                           @RequestParam double lon,
                                                           @RequestParam double lat) {
        return ResponseEntity.ok(service.getPlaceList(radius, lon, lat));
    }

    @GetMapping("properties")
    public ResponseEntity<PlacePropertiesDto> getPlaceProperties(@RequestParam String xid) {
        return ResponseEntity.ok(service.getPlaceProp(xid));
    }

    @GetMapping("interesting")
    public ResponseEntity<List<PlacePropertiesDto>> getInterestingPlaces(@RequestParam String placeName) {
        return ResponseEntity.ok(service.getInterestingPlacesNearby(placeName));
    }
}
