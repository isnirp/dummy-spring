package com.flimbis.model;

import com.flimbis.repo.ToppingRepository;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "topping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
