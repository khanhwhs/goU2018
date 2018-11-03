package com.home.gou.service;

import com.home.gou.entity.CarEntity;
import com.home.gou.entity.UserEntity;
import com.home.gou.model.Car;
import com.home.gou.model.User;
import com.home.gou.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Car findById(int id){
        Optional<CarEntity> carEntity = carRepository.findById(id);
        Car car = new Car(carEntity.get().getId(),carEntity.get().getMake(),carEntity.get().getModel(),carEntity.get().getYearMake() );
        return car;
    }

    public Car convert(CarEntity carEntity ){

        return modelMapper.map(carEntity,Car.class);
    }

    public void saveCar(Car car) {
        CarEntity carEntity = modelMapper.map(car,CarEntity.class);
        carRepository.save(carEntity);
    }
}
