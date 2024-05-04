package com.techie.product.utility;

import com.techie.product.dto.ProductResponseDto;
import com.techie.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseUtility {
    public Product toEntity(ProductResponseDto dto)
    {
        return Product
                .builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build();
    }

    public ProductResponseDto toDto(Product product)
    {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
