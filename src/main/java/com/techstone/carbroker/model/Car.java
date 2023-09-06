package com.techstone.carbroker.model;

import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean fourByFour;

    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

    @Enumerated(EnumType.STRING)
    private Age age;

    private Boolean automaticTransmission;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    public Car(boolean parseBoolean, PriceRange valueOf, Age valueOf1, boolean parseBoolean1, FuelType valueOf2) {
    }
}