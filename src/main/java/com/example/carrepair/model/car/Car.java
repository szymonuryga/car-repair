package com.example.carrepair.model.car;

import com.example.carrepair.model.repair.Repair;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String registrationNumber;
    private String Vin;
    private String model;
    private String brand;
    @OneToMany(mappedBy = "car")
    private List<Repair> repairs = new ArrayList<>();

}
