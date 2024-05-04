package com.techie.product.utility;


import com.techie.product.dto.ProductRequestDto;
import com.techie.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestUtility {
    public Product toEntity(ProductRequestDto dto)
    {
        return Product
                .builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build();
    }

    public ProductRequestDto toDto(Product product)
    {
        return new ProductRequestDto(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
