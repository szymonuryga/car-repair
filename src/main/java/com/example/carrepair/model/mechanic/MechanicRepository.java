package com.example.carrepair.model.mechanic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MechanicRepository extends JpaRepository<Mechanic, UUID> {
}
