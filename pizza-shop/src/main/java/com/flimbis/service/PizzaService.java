package com.flimbis.service;

import com.flimbis.model.Pizza;
import com.flimbis.model.PizzaSize;
import com.flimbis.model.dto.PizzaBase;
import com.flimbis.repo.PizzaRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public int makePizza(PizzaBase pizzaBase) {
        Pizza pizza = new Pizza();
        pizza.setCrust(pizzaBase.crust());
        pizza.setSize(PizzaSize.valueOf(pizzaBase.size()));

        return pizzaRepository.save(pizza).getId();
    }
}
