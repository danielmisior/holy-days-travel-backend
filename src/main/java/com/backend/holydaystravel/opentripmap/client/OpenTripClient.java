package com.backend.holydaystravel.opentripmap.client;

import com.backend.holydaystravel.opentripmap.config.OpenTripConfig;
import com.backend.holydaystravel.opentripmap.dto.GeoCoordsDto;
import com.backend.holydaystravel.opentripmap.dto.PlaceListDto;
import com.backend.holydaystravel.opentripmap.dto.PlacePropertiesDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class OpenTripClient {
    private final OpenTripConfig config;
    private final RestTemplate restTemplate;
    private static final String KEY = "X-RapidAPI-Key";
    private static final String HOST = "X-RapidAPI-Host";

    private HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(KEY, config.getOpenTripMapApiKey());
        headers.set(HOST, config.getOpenTripMapApiHost());
        return headers;
    }

    public GeoCoordsDto getCoordinatesByName(String placeName) {
        try {
            HttpEntity<Void> httpEntity = new HttpEntity<>(setHeaders());
            return restTemplate.exchange(makeURLForCoords(placeName), HttpMethod.GET, httpEntity, GeoCoordsDto.class).getBody();
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private URI makeURLForCoords(String placeName) {
        return UriComponentsBuilder
                .fromHttpUrl(config.getOpenTripMapApiEndpoint() + "/geoname")
                .queryParam("name", placeName)
                .build()
                .encode()
                .toUri();
    }

    public List<PlaceListDto> getPlaceListByRadius(int radius, double lon, double lat) {
        try {
            HttpEntity<Void> httpEntity = new HttpEntity<>(setHeaders());
            ResponseEntity<PlaceListDto[]> response = restTemplate.exchange(makeURLForPlaceList(radius, lon, lat), HttpMethod.GET, httpEntity, PlaceListDto[].class);

            return new ArrayList<>(Optional.ofNullable(response.getBody())
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList()));
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    private URI makeURLForPlaceList(int radius, double lon, double lat) {
        return UriComponentsBuilder
                .fromHttpUrl(config.getOpenTripMapApiEndpoint() + "/radius")
                .queryParam("radius", radius)
                .queryParam("lon", lon)
                .queryParam("lat", lat)
                .queryParam("format", "json")
                .queryParam("rate", 3)
                .queryParam("limit", 5)
                .build()
                .encode()
                .toUri();
    }

    public PlacePropertiesDto getPlaceProperties(String xid) {
        try {
            HttpEntity<Void> httpEntity = new HttpEntity<>(setHeaders());
            return restTemplate.exchange(makeURLForPlaceProp(xid), HttpMethod.GET, httpEntity, PlacePropertiesDto.class).getBody();
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private URI makeURLForPlaceProp(String xid) {
        return UriComponentsBuilder
                .fromHttpUrl(config.getOpenTripMapApiEndpoint() + "/xid/" + xid)
                .build()
                .encode()
                .toUri();
    }
}