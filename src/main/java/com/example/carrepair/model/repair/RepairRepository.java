package com.example.carrepair.model.repair;

import com.example.carrepair.model.car.Car;
import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.mechanic.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAllByClient(Client client);
    Optional<Repair> findByMechanic_EmailAndEndIsNull(String email);

    @Query("SELECT r.mechanic, COUNT(r.mechanic) AS value_occurrence FROM Repair r GROUP BY r.mechanic ORDER BY value_occurrence DESC")
    List<Mechanic> findTheMostFrequentlyMechanic();

    @Query("SELECT r.category, COUNT(r.category) AS value_occurrence FROM Repair r GROUP BY r.category ORDER BY value_occurrence DESC")
    List<Category> findTheMostFrequentlyCategory();

    @Query("SELECT r.client, COUNT(r.client) AS value_occurrence FROM Repair r GROUP BY r.client ORDER BY value_occurrence DESC")
    List<Client> findTheMostFrequentlyClient();

    @Query("SELECT r.car, COUNT(r.car) AS value_occurrence FROM Repair r GROUP BY r.car ORDER BY value_occurrence DESC")
    List<Car> findTheMostFrequentlyCar();
}
