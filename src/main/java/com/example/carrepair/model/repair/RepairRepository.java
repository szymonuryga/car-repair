package com.example.carrepair.model.repair;

import com.example.carrepair.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAllByClient(Client client);
    Optional<Repair> findByMechanic_EmailAndEndIsNull(String email);
}
