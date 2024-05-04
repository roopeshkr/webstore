package com.techie.order.utility;

import com.techie.order.dto.OrderResponseDto;
import com.techie.order.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseUtility {
    public Order toEntity(OrderResponseDto dto)
    {
        return Order
                .builder()
                .id(dto.id())
                .orderNumber(dto.orderNumber())
                .skuCode(dto.skuCode())
                .price(dto.price())
                .quantity(dto.quantity())
                .build();
    }

    public OrderResponseDto toDto(Order order)
    {
        return new OrderResponseDto(
                order.getId(),
                order.getOrderNumber(),
                order.getSkuCode(),
                order.getPrice(),
                order.getQuantity()
        );
    }
}
