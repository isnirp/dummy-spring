package com.flimbis.controller;

import com.flimbis.service.ToppingService;
import org.springframework.web.bind.annotation.*;

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
}
