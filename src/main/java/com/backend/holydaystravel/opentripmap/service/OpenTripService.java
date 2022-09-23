package com.backend.holydaystravel.opentripmap.service;

import com.backend.holydaystravel.opentripmap.client.OpenTripClient;
import com.backend.holydaystravel.opentripmap.dto.GeoCoordsDto;
import com.backend.holydaystravel.opentripmap.dto.PlaceListDto;
import com.backend.holydaystravel.opentripmap.dto.PlacePropertiesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenTripService {
    private final OpenTripClient client;

    public GeoCoordsDto getCoordinates(String placeName) {
        return client.getCoordinatesByName(placeName);
    }

    public List<PlaceListDto> getPlaceList(int radius, double lon, double lat) {
        return client.getPlaceListByRadius(radius, lon, lat);
    }

    public PlacePropertiesDto getPlaceProp(String xid) {
        return client.getPlaceProperties(xid);
    }

    public List<PlacePropertiesDto> getInterestingPlacesNearby(String placeName) {
        GeoCoordsDto coords = getCoordinates(placeName);
        List<PlaceListDto> placeList = getPlaceList(5000, coords.getLon(), coords.getLat());
        List<PlacePropertiesDto> interestingPlaces = new ArrayList<>();
        for (PlaceListDto places : placeList) {
            PlacePropertiesDto place = getPlaceProp(places.getXid());
            interestingPlaces.add(place);
        }
        return interestingPlaces;
    }
}
