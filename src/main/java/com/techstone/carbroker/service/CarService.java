package com.techstone.carbroker.service;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import com.techstone.carbroker.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> saveAll(List<Car> cars) {
        return carRepository.saveAll(cars);
    }

    public List<Car> findByFilters(Age age, FuelType fuelType, PriceRange priceRange,
                                   boolean automaticTransmission, boolean fourByFour) {
        return carRepository.findByFilters(age, fuelType, priceRange, automaticTransmission, fourByFour);
    }

}