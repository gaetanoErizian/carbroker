package com.techstone.carbroker.repository;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByFilters(Age age, FuelType fuelType, PriceRange priceRange, boolean automaticTransmission, boolean fourByFour);
    // Qui vanno inseriti i metodi per le query
}