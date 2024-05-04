package com.techie.order.utility;

import com.techie.order.dto.OrderRequestDto;
import com.techie.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestUtility {
    public Order toEntity(OrderRequestDto dto)
    {
        return Order
                .builder()
                .orderNumber(dto.orderNumber())
                .skuCode(dto.skuCode())
                .price(dto.price())
                .quantity(dto.quantity())
                .build();
    }

    public OrderRequestDto toDto(Order order)
    {
        return new OrderRequestDto(
                order.getOrderNumber(),
                order.getSkuCode(),
                order.getPrice(),
                order.getQuantity()
        );
    }
}
