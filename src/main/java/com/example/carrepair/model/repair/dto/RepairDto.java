package com.example.carrepair.model.repair.dto;

import com.example.carrepair.model.mechanic.Mechanic;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RepairDto {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private double price;
    private String nationalId;
    private String firstName;
    private String lastName;
    private String registrationNumber;
    private String category;
    private String email;
}
