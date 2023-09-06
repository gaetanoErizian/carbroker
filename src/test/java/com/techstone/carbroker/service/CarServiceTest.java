package com.techstone.carbroker.service;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCars() {
        Car car1 = new Car(); // set attributes
        Car car2 = new Car(); // set attributes

        when(carRepository.findAll()).thenReturn(Arrays.asList(car1, car2));

        List<Car> result = carService.getAllCars();
        assertEquals(2, result.size());
    }

}