package com.example.carrepair.model.client.dto;

import com.example.carrepair.model.client.Client;

public class ClientMapper {
    public ClientDto toDto(Client client){
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setNationalId(client.getNationalId());
        return dto;
    }

    public Client toEntity(ClientDto client){
        Client entity = new Client();
        entity.setId(client.getId());
        entity.setFirstName(client.getFirstName());
        entity.setLastName(client.getLastName());
        entity.setPhoneNumber(client.getPhoneNumber());
        entity.setNationalId(client.getNationalId());
        return entity;
    }
}
