package com.backend.holydaystravel.openweather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private long id;
    private String main;
    private String description;
    private String icon;
}
