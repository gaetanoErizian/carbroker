package com.techstone.carbroker.repository.custom;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;

import java.util.List;

public interface CarRepositoryCustom {
    List<Car> findByFilters(Age age, FuelType fuelType, PriceRange priceRange,
                            boolean automaticTransmission, boolean fourByFour);
}