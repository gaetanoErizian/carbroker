package com.techstone.carbroker.controller;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.model.entities.Age;
import com.techstone.carbroker.model.entities.FuelType;
import com.techstone.carbroker.model.entities.PriceRange;
import com.techstone.carbroker.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/bulk")
    public ResponseEntity<String> bulkInsertCars(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please provide a CSV file.");
        }

        List<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Skip the header row
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Assuming columns are in the order: fourByFour, priceRange, age, automaticTransmission, fuelType
                Car car = new Car(
                        Boolean.parseBoolean(values[0]),
                        PriceRange.valueOf(values[1].toUpperCase()),
                        Age.valueOf(values[2]),
                        Boolean.parseBoolean(values[3]),
                        FuelType.valueOf(values[4].toUpperCase())
                );

                cars.add(car);
            }
        }

        carService.saveAll(cars);

        return ResponseEntity.ok("Cars imported successfully!");
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

}