package com.flimbis.service;

import com.flimbis.model.Topping;
import com.flimbis.model.dto.ToppingDtoMapper;
import com.flimbis.repo.ToppingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ToppingServiceTest {
    private ToppingService toppingService;
    @Mock
    private ToppingRepository repository;
    @Mock
    private ToppingDtoMapper mapper;

    @BeforeEach
    void setUp() {
        toppingService = new ToppingService(repository, mapper);
    }

   /* @Test
    void deleteTopping() {
        Topping topping = new Topping(1, "cheese");
        ArgumentCaptor<Topping> captor = ArgumentCaptor.forClass(Topping.class);

        when(repository.findByIdPizza(1, 2))
                .thenReturn(Optional.of(topping));

        toppingService.deletePizzaTopping(2, 1 );

        verify(repository, times(1)).delete(captor.capture());
        assertThat(topping).isEqualTo(captor.getValue());
    }*/
}