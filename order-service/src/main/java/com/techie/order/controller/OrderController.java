package com.techie.order.controller;

import com.techie.order.dto.OrderRequestDto;
import com.techie.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDto requestDto)
    {
        orderService.placeOrder(requestDto);
        return "Order Placed Successfully";
    }
}
