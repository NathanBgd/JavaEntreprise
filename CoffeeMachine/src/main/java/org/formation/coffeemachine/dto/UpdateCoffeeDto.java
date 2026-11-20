package org.formation.coffeemachine.dto;

import jakarta.validation.constraints.Positive;

public record UpdateCoffeeDto(
        String name,
        @Positive(message = "Price should be positive") Integer price
) {
}
