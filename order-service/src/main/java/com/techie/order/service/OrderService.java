package com.techie.order.service;

import com.techie.order.client.InventoryClient;
import com.techie.order.dto.OrderRequestDto;
import com.techie.order.model.Order;
import com.techie.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public void placeOrder(OrderRequestDto orderRequestDto){
        var isProductInStock=inventoryClient.isInStock(orderRequestDto.skuCode(),orderRequestDto.quantity());
        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequestDto.price());
            order.setSkuCode(orderRequestDto.skuCode());
            order.setQuantity(orderRequestDto.quantity());
            orderRepository.save(order);
        }else {
            throw new RuntimeException("Product with SkuCode "+orderRequestDto.skuCode()+" is not in stock");
        }
    }
}
