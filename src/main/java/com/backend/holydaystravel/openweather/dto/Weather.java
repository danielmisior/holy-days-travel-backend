package com.backend.holydaystravel.openweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
