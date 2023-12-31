package com.flimbis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flimbis.model.dto.PizzaBase;
import com.flimbis.model.dto.PizzaDto;
import com.flimbis.service.PizzaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PizzaController.class)
class PizzaControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private PizzaService pizzaService;

    @Test
    void createPizza201() throws Exception {
        PizzaBase pizzaBase = new PizzaBase("MEDIUM", "basic");
        when(pizzaService.makePizza(any(PizzaBase.class))).thenReturn(1);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/pizza")
                .content(asJsonString(pizzaBase))
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isCreated());
    }

    @Test
    void givenPizzaIdGetPizza200() throws Exception {
        PizzaDto pizzaDto = PizzaDto.builder()
                .id(1)
                .size("MEDIUM")
                .crust("basic")
                .build();

        when(pizzaService.getPizza(1)).thenReturn(pizzaDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pizza/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}