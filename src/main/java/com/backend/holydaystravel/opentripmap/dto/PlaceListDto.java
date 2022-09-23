package com.backend.holydaystravel.opentripmap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceListDto {

    @JsonProperty("xid")
    private String xid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dist")
    private double dist;

    @JsonProperty("point")
    private Point point;
}