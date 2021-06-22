package com.example.carrepair.model.mechanic;

import com.example.carrepair.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MECHANICS")
public class Mechanic extends Person {
    private String email;
}
