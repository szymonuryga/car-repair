package com.example.carrepair.model.car;

import com.example.carrepair.model.car.dto.CarDto;
import com.example.carrepair.model.car.dto.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    CarMapper carMapper = new CarMapper();

    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CarDto> findById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDto);
    }

    public void removeCar(Long id) {
        carRepository.deleteById(id);
    }

    public CarDto save(CarDto car) {
        Optional<Car> carByRegistrationNumber = carRepository.findByRegistrationNumber(car.getRegistrationNumber());
        carByRegistrationNumber.ifPresent(a -> {
            throw new DuplicateRegistrationNumber();
        });
        return mapAndSave(car);
    }

    public CarDto update(CarDto car) {
        Optional<Car> carByRegistrationNumber = carRepository.findByRegistrationNumber(car.getRegistrationNumber());
        carByRegistrationNumber.ifPresent(a -> {
            if (!a.getId().equals(car.getId()))
                throw new DuplicateRegistrationNumber();
        });
        return mapAndSave(car);
    }

    private CarDto mapAndSave(CarDto car) {
        Car carEntity = carMapper.toEntity(car);
        Car savedCar = carRepository.save(carEntity);
        return carMapper.toDto(savedCar);
    }
}
