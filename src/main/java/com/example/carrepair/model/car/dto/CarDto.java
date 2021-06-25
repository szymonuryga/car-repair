package com.example.carrepair.model.car.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String registrationNumber;
    private String Vin;
    private String model;
    private String brand;
}
