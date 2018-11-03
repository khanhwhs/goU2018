package com.home.gou.controller;

import com.home.gou.model.Car;
import com.home.gou.model.User;
import com.home.gou.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value="findCarById")
    public Car findCarById(int id){
        return carService.findById(id);
    }

    @PostMapping(value="/addCar")
    public void addCar(@RequestBody Car car
    ){
        carService.saveCar(car);
    }
}
