package com.example.carrepair.model.mechanic;

import com.example.carrepair.model.person.Person;
import com.example.carrepair.model.repair.Repair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MECHANICS")
public class Mechanic extends Person {
    @Column(unique = true)
    private String email;
    private double salary;
    @OneToMany(mappedBy = "mechanic")
    private Set<Repair> repairs = new HashSet<>();

    public void setEmail(String firstName, String lastName) {
        this.email = firstName.toLowerCase().substring(0,3)+lastName.toLowerCase()+"@car.repair.com";
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
