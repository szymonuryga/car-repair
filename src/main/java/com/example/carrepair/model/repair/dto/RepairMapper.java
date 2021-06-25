package com.example.carrepair.model.repair.dto;


import com.example.carrepair.model.car.Car;
import com.example.carrepair.model.car.CarRepository;
import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.category.CategoryRepository;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.client.ClientRepository;
import com.example.carrepair.model.mechanic.Mechanic;
import com.example.carrepair.model.mechanic.MechanicRepository;
import com.example.carrepair.model.repair.Repair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepairMapper {

    private final CategoryRepository categoryRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;


    public static RepairDto toDto(Repair repair){
        RepairDto dto = new RepairDto();
        dto.setId(repair.getId());
        dto.setPrice(repair.getPrice());
        dto.setStart(repair.getStart());
        dto.setEnd(repair.getEnd());
        Client client = repair.getClient();
        dto.setNationalId(client.getNationalId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        Car car = repair.getCar();
        dto.setRegistrationNumber(car.getRegistrationNumber());
        if(repair.getCategory()!= null)
            dto.setCategory(repair.getCategory().getName());
        Mechanic mechanic = repair.getMechanic();
        dto.setEmail(mechanic.getEmail());
        return dto;
    }

    public Repair toEntity(RepairDto repair){
        Repair entity = new Repair();
        entity.setId(repair.getId());
        entity.setPrice(repair.getPrice());
        entity.setStart(repair.getStart());
        entity.setEnd(repair.getEnd());
        Optional<Client> client = clientRepository.findClientByNationalId(repair.getNationalId());
        client.ifPresent(entity::setClient);
        Optional<Car> car = carRepository.findByRegistrationNumber(repair.getRegistrationNumber());
        car.ifPresent(entity::setCar);
        Optional<Category> category = categoryRepository.findByName(repair.getCategory());
        category.ifPresent(entity::setCategory);
        Optional<Mechanic> mechanic = mechanicRepository.findByEmail(repair.getEmail());
        mechanic.ifPresent(entity::setMechanic);
        return entity;
    }

}
