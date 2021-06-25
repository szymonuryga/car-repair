package com.example.carrepair.model.mechanic.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MechanicDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email ;
    private double salary;
}
