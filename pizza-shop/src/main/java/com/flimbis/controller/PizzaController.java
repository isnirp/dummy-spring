package com.flimbis.controller;

import com.flimbis.model.dto.PizzaBase;
import com.flimbis.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPizza(@RequestBody PizzaBase pizzaBase) {
        pizzaService.makePizza(pizzaBase);
    }

}
