package com.techstone.carbroker.controller;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import com.techstone.carbroker.tools.CsvParse;

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

        List<Car> cars = CsvParse.getCarsListFromCsv(file);

        carService.saveAll(cars);

        return ResponseEntity.ok("Cars imported successfully!");
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

}