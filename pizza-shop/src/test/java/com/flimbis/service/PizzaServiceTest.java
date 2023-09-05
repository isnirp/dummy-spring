package com.flimbis.service;

import com.flimbis.model.Pizza;
import com.flimbis.model.PizzaSize;
import com.flimbis.model.Topping;
import com.flimbis.model.dto.PizzaBase;
import com.flimbis.repo.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceTest {
    private PizzaService service;
    @Mock
    private PizzaRepository pizzaRepository;

    @BeforeEach
    void setUp() {
        service = new PizzaService(pizzaRepository);
    }

    @Test
    void testMakePizza() {
        PizzaBase pizzaBase = new PizzaBase("MEDIUM", "basic");

        Pizza pizza = Pizza.builder()
                .id(1)
                .size(PizzaSize.MEDIUM)
                .crust("basic")
                .build();

        when(pizzaRepository.save(any(Pizza.class))).thenReturn(pizza);
        int result = service.makePizza(pizzaBase);

        assertThat(result).isNotNull();
    }
}