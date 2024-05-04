package com.techie.product.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Product must have a name")
        String name,
        @NotBlank(message = "Product must have a description")
        String description,
        BigDecimal price
) {
}
