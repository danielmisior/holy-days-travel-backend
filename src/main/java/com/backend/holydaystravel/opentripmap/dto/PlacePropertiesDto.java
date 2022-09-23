package com.backend.holydaystravel.opentripmap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlacePropertiesDto {
    private String xid;
    private String name;
    private String otm;
    private String image;
    private Preview preview;
    @JsonProperty("wikipedia_extracts")
    private WikiExtracts wiki;
}
