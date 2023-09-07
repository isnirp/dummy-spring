package com.flimbis.service;

import com.flimbis.model.Pizza;
import com.flimbis.model.PizzaSize;
import com.flimbis.model.Topping;
import com.flimbis.model.dto.PizzaBase;
import com.flimbis.model.dto.PizzaDto;
import com.flimbis.model.dto.PizzaDtoMapper;
import com.flimbis.repo.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceTest {
    private PizzaService service;
    @Mock
    private PizzaRepository pizzaRepository;
    @Mock
    private PizzaDtoMapper mapper;

    @BeforeEach
    void setUp() {
        service = new PizzaService(pizzaRepository, mapper);
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

    @Test
    void testGetAllPizzas() {
        Pizza pizza = Pizza.builder()
                .id(1)
                .size(PizzaSize.MEDIUM)
                .crust("basic")
                .build();

        PizzaDto pizzaDto = PizzaDto.builder()
                .id(1)
                .size("MEDIUM")
                .crust("basic")
                .build();

        List<Pizza> pizzaList = List.of(pizza);

        when(pizzaRepository.findAll()).thenReturn(pizzaList);
        when(mapper.apply(pizza)).thenReturn(pizzaDto);

        List<PizzaDto> result = service.getAllPizzas();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testGetPizza() {
        Pizza pizza = Pizza.builder()
                .id(1)
                .size(PizzaSize.MEDIUM)
                .crust("basic")
                .build();

        PizzaDto pizzaDto = PizzaDto.builder()
                .id(1)
                .size("MEDIUM")
                .crust("basic")
                .build();

        when(pizzaRepository.findById(1)).thenReturn(Optional.of(pizza));
        when(mapper.apply(pizza)).thenReturn(pizzaDto);
        PizzaDto result = service.getPizza(1);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
    }
}