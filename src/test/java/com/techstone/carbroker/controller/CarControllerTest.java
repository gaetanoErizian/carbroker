package com.techstone.carbroker.controller;

import com.techstone.carbroker.model.Car;
import com.techstone.carbroker.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CarControllerTest {

    @InjectMocks
    private CarController carController;

    @Mock
    private CarService carService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCars() {
        Car car1 = new Car(); // set attributes
        Car car2 = new Car(); // set attributes

        when(carService.getAllCars()).thenReturn(Arrays.asList(car1, car2));

        List<Car> response = carController.getAllCars();
        assertEquals(2, response.size());
    }

}