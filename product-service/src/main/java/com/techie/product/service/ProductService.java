package com.techie.product.service;

import com.techie.product.dto.ProductRequestDto;
import com.techie.product.dto.ProductResponseDto;
import com.techie.product.model.Product;
import com.techie.product.repository.ProductRepository;
import com.techie.product.utility.ProductRequestUtility;
import com.techie.product.utility.ProductResponseUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductRequestUtility productRequestUtility;
    private final ProductResponseUtility productResponseUtility;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto)
    {
        Product product=productRequestUtility.toEntity(productRequestDto);
        productRepository.save(product);
        log.info("Product created successfully");
        return productResponseUtility.toDto(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productResponseUtility::toDto)
                .toList();
    }
}
