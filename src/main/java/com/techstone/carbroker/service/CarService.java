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

    public List<Car> getCarsListFromCsv(MultipartFile file) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Skip the header row
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Assuming columns are in the order: fourByFour, priceRange, age, automaticTransmission, fuelType
                Car car = new Car();
                car.setFourByFour(Boolean.parseBoolean(values[0]));
                car.setPriceRange(PriceRange.valueOf(values[1].toUpperCase()));
                car.setAge(Age.valueOf(values[2]));
                car.setAutomaticTransmission(Boolean.parseBoolean(values[3]));
                car.setFuelType(FuelType.valueOf(values[4].toUpperCase()));

                cars.add(car);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

}