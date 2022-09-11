package com.backend.holydaystravel.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private String country;
    private String address;
    private Integer stars;
    private Double pricePerNight;
    private Integer nightsNumber;
}
