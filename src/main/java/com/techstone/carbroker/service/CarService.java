package com.techstone.carbroker.service;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}