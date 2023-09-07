package com.flimbis.controller;

import com.flimbis.model.dto.PizzaBase;
import com.flimbis.model.dto.PizzaDto;
import com.flimbis.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<PizzaDto> getPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public PizzaDto getPizza(@PathVariable int id) {
        return pizzaService.getPizza(id);
    }

}
