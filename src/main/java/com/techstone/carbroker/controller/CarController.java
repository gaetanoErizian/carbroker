package com.techstone.carbroker.controller;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/bulk")
    public List<Car> bulkInsertCars(@RequestBody List<Car> cars) {
        return carService.saveAll(cars);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

}