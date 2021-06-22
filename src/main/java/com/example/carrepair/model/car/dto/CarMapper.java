package com.example.carrepair.model.car.dto;

import com.example.carrepair.model.car.Car;

public class CarMapper {

    public CarDto toDto(Car car){
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setVin(car.getVin());
        dto.setRegistrationNumber(car.getRegistrationNumber());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        return dto;
    }

    public Car toEntity(CarDto car){
        Car entity = new Car();
        entity.setId(car.getId());
        entity.setVin(car.getVin());
        entity.setRegistrationNumber(car.getRegistrationNumber());
        entity.setBrand(car.getBrand());
        entity.setModel(car.getModel());
        return entity;
    }
}
