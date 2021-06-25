package com.example.carrepair.model.repair;

import com.example.carrepair.model.car.Car;
import com.example.carrepair.model.category.Category;
import com.example.carrepair.model.client.Client;
import com.example.carrepair.model.mechanic.Mechanic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "REPAIRS")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;
    @ManyToOne
    private Car car;
}
