package com.backend.holydaystravel.openweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}
