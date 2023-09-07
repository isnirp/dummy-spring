package com.flimbis.model.dto;

import com.flimbis.model.Pizza;

import java.util.function.Function;

public class PizzaDtoMapper implements Function<Pizza, PizzaDto> {
    @Override
    public PizzaDto apply(Pizza pizza) {
        return PizzaDto.builder()
                .id(pizza.getId())
                .crust(pizza.getCrust())
                .size(String.valueOf(pizza.getSize()))
                .toppings(pizza.getToppings())
                .build();
    }
}
