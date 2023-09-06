package com.techstone.carbroker.repository;

import com.techstone.carbroker.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Qui vanno inseriti i metodi per le query
}