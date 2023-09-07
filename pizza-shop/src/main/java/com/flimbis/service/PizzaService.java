package com.flimbis.service;

import com.flimbis.model.Pizza;
import com.flimbis.model.PizzaSize;
import com.flimbis.model.dto.PizzaBase;
import com.flimbis.model.dto.PizzaDto;
import com.flimbis.model.dto.PizzaDtoMapper;
import com.flimbis.repo.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaDtoMapper mapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaDtoMapper mapper) {
        this.pizzaRepository = pizzaRepository;
        this.mapper = mapper;
    }

    public int makePizza(PizzaBase pizzaBase) {
        Pizza pizza = new Pizza();
        pizza.setCrust(pizzaBase.crust());
        pizza.setSize(PizzaSize.valueOf(pizzaBase.size()));

        return pizzaRepository.save(pizza).getId();
    }

    public List<PizzaDto> getAllPizzas() {
        return pizzaRepository.findAll().stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public PizzaDto getPizza(int i) {
        Pizza pizza = pizzaRepository.findById(i).orElseThrow(RuntimeException::new);
        return mapper.apply(pizza);
    }
}
