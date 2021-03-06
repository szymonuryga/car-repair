package com.example.carrepair.api.car;

import com.example.carrepair.model.car.CarService;
import com.example.carrepair.model.car.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> findAll(){
        return carService.findAll();
    }

    @GetMapping("/registrations")
    public List<String> findALlRegistrationNumbers(){
        return carService.findALlRegistrationNumbers();
    }

    @GetMapping("/brand")
    public String findTheMostFrequentlyBrand(){
        return carService.getTheMostFrequentlyBrand();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findById(@PathVariable Long id){
        return carService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto createCar(@RequestBody CarDto car){
        return carService.save(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id){
        carService.removeCar(id);
    }

}
