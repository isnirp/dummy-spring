package com.flimbis.model.dto;

import com.flimbis.model.Topping;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ToppingDtoMapper implements Function<Topping, ToppingDto> {
    @Override
    public ToppingDto apply(Topping topping) {
        return new ToppingDto(topping.getId(), topping.getName());
    }
}
