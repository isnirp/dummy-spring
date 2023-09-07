package com.flimbis.model;

import com.flimbis.repo.ToppingRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topping")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private Pizza pizza;

    public Topping(String name) {
        this.name = name;
    }

    public Topping(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
