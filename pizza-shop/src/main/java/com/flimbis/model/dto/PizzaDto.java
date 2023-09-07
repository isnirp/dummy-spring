package com.flimbis.model.dto;

import com.flimbis.model.PizzaSize;
import com.flimbis.model.Topping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PizzaDto {
    private int id;
    private String crust;
    private String size;
    private List<Topping> toppings;
}
