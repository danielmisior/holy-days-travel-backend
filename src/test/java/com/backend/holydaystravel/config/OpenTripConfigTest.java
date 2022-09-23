package com.backend.holydaystravel.config;

import com.backend.holydaystravel.opentripmap.config.OpenTripConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class OpenTripConfigTest {
    private OpenTripConfig config;

    @Test
    void gettersShouldBeNull() {
        //Given
        config = new OpenTripConfig();

        //When
        String endpoint = config.getOpenTripMapApiEndpoint();
        String key = config.getOpenTripMapApiKey();
        String host = config.getOpenTripMapApiHost();

        //Then
        assertNull(endpoint);
        assertNull(key);
        assertNull(host);
    }
}
