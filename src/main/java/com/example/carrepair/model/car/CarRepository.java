package com.example.carrepair.model.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByRegistrationNumber(String registrationNumber);

    @Query("SELECT c.brand, COUNT(c.brand) AS value_occurrence FROM Car c GROUP BY c.brand ORDER BY value_occurrence DESC")
    String[] findTheMostFrequentlyBrand();
}
