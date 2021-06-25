package com.example.carrepair.model.category;

import com.example.carrepair.model.repair.Repair;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany( cascade=CascadeType.ALL, mappedBy = "category")
    private List<Repair> reapirs = new ArrayList<>();
}
