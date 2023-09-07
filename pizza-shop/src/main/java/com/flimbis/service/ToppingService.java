package com.flimbis.service;

import com.flimbis.model.Topping;
import com.flimbis.repo.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToppingService {
    private final ToppingRepository repository;

    public ToppingService(ToppingRepository repository) {
        this.repository = repository;
    }

    public int addTopping(String topping) {
        return repository.save(new Topping(topping))
                .getId();
    }

    // get toppings of a pizza
    public List<Topping> getPizzaToppings(int pizzaId) {
        return repository.findAll().stream()
                .filter(topping -> topping.getPizza().getId() == pizzaId)
                .collect(Collectors.toList());
    }

    public void deletePizzaTopping(int pizzaId, int toppingId) {
        Topping topping = repository.findByIdPizzaId(toppingId, pizzaId)
                .orElseThrow(RuntimeException::new);

        repository.delete(topping);
    }
}
