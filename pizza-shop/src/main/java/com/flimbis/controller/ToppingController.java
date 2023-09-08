package com.flimbis.controller;

import com.flimbis.model.dto.ToppingDto;
import com.flimbis.service.ToppingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class ToppingController {
    private final ToppingService service;

    public ToppingController(ToppingService service) {
        this.service = service;
    }

    @PostMapping("/{id}/toppings")
    public void createToppings(@PathVariable int id, @RequestBody String topping) {
        service.addTopping(id, topping);
    }

    @GetMapping("/{id}/toppings")
    public List<ToppingDto> getToppings(@PathVariable int id) {
        return service.getPizzaToppings(id);
    }

    @DeleteMapping("/{id}/toppings/{toppingId}")
    public void deleteTopping(@PathVariable int id, @PathVariable int toppingId) {
        service.deletePizzaTopping(id, toppingId);
    }
}
