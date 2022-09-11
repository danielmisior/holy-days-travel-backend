package com.backend.holydaystravel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "HOTELS")
public final class Hotel {
    @Id
    @Column(name = "HOTEL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hotelId;

    @Column(name = "NAME")
    private String hotelName;

    @NotNull
    @Column(name = "COUNTRY")
    private String country;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STARS")
    private Integer stars;

    @Column(name = "PRICE_PER_NIGHT")
    private Double pricePerNight;

    @Column(name = "NUMBER_OF_NIGHTS")
    private Integer nightsNumber;

    @OneToOne(mappedBy = "hotel")
    private Tour tour;
}
