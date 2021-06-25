package com.example.carrepair.model.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByNationalId(String nationalId);
}
