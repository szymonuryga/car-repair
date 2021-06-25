package com.example.carrepair.model.repair;

import com.example.carrepair.model.car.Car;
import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.mechanic.Mechanic;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime acceptanceDate = LocalDateTime.now();
    private double price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Client client;
    @ManyToMany(mappedBy = "repairs")
    private List<Mechanic> mechanics = new ArrayList<>();
    @ManyToOne
    private Car car;
}
