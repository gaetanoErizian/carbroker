package com.techstone.carbroker.model;

import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

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

}