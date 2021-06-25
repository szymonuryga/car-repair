package com.example.carrepair.model.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String nationalId;
}
