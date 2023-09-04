package com.flimbis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pizza")
@Getter
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
