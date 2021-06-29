package com.example.carrepair.model.mechanic.dto;


import com.example.carrepair.model.mechanic.Mechanic;

public class MechanicMapper {
    public MechanicDto toDto(Mechanic mechanic){
        MechanicDto dto = new MechanicDto();
        dto.setId(mechanic.getId());
        dto.setFirstName(mechanic.getFirstName());
        dto.setLastName(mechanic.getLastName());
        dto.setPhoneNumber(mechanic.getPhoneNumber());
        dto.setEmail(mechanic.getEmail());
        dto.setSalary(mechanic.getSalary());
        return dto;
    }

    public Mechanic toEntity(MechanicDto mechanic){
        Mechanic entity = new Mechanic();
        entity.setId(mechanic.getId());
        entity.setFirstName(mechanic.getFirstName());
        entity.setLastName(mechanic.getLastName());
        entity.setPhoneNumber(mechanic.getPhoneNumber());
        entity.setEmail(entity.getFirstName(), entity.getLastName());
        entity.setSalary(mechanic.getSalary());
        return entity;
    }
}
