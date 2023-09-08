package com.flimbis.model.dto;

import com.flimbis.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PizzaDtoMapper implements Function<Pizza, PizzaDto> {
    @Override
    public PizzaDto apply(Pizza pizza) {
        return PizzaDto.builder()
                .id(pizza.getId())
                .crust(pizza.getCrust())
                .size(String.valueOf(pizza.getSize()))
                .toppings(pizza.getToppings().stream()
                        .map(topping -> new ToppingDtoMapper().apply(topping))
                        .collect(Collectors.toList()))
                .build();
    }
}
