package com.project.springbootbackend.controller;


import com.project.springbootbackend.dto.OrderRequestDto;
import com.project.springbootbackend.dto.OrderResponseDto;
import com.project.springbootbackend.entity.Order;
import com.project.springbootbackend.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService iOrderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        iOrderService.createOrder(orderRequestDto);
        return ResponseEntity.ok("Order created");

    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> loadCustomerOrders(){
        return ResponseEntity.ok(iOrderService.getCustomerOrders());
    }


}
