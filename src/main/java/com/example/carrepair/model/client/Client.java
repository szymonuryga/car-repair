package com.example.carrepair.model.client;


import com.example.carrepair.model.person.Person;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENTS")
public class Client extends Person {
    @Column(unique = true)
    private String nationalId;

}
