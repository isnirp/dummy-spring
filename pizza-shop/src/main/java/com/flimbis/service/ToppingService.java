package com.flimbis.service;

import com.flimbis.model.Pizza;
import com.flimbis.model.Topping;
import com.flimbis.model.dto.ToppingDto;
import com.flimbis.model.dto.ToppingDtoMapper;
import com.flimbis.repo.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToppingService {
    private final ToppingRepository repository;
    private final ToppingDtoMapper mapper;

    public ToppingService(ToppingRepository repository, ToppingDtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public int addTopping(int pizzaId, String name) {
        Pizza pizza = Pizza.builder()
                .id(pizzaId)
                .build();

        Topping topping = new Topping();
        topping.setName(name);
        topping.setPizza(pizza);

        return repository.save(topping)
                .getId();
    }

    // get toppings of a pizza
    public List<ToppingDto> getPizzaToppings(int pizzaId) {
        return repository.findAll().stream()
                .filter(topping -> topping.getPizza().getId() == pizzaId)
                .map(mapper)
                .collect(Collectors.toList());
    }

   /* public void deletePizzaTopping(int pizzaId, int toppingId) {
        Topping topping = repository.findByIdPizza(toppingId, pizzaId)
                .orElseThrow(RuntimeException::new);

        repository.delete(topping);
    }*/
}
