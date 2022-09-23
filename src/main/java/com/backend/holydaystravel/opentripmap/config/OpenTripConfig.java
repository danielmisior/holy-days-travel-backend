package com.backend.holydaystravel.opentripmap.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class OpenTripConfig {

    @Value("${open.trip.map.api.endpoint}")
    private String openTripMapApiEndpoint;

    @Value("${open.trip.map.api.key}")
    private String openTripMapApiKey;

    @Value("${open.trip.map.api.host}")
    private String openTripMapApiHost;
}
