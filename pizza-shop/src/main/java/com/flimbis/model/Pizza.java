package com.flimbis.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String crust;
    @Enumerated(EnumType.STRING)
    private PizzaSize size;
    @OneToMany(mappedBy = "pizza")
    private List<Topping> toppings;
}
