package com.project.springbootbackend.service;

import com.project.springbootbackend.dto.OrderRequestDto;
import com.project.springbootbackend.dto.OrderResponseDto;
import com.project.springbootbackend.entity.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(OrderRequestDto orderRequest);
    List<OrderResponseDto> getCustomerOrders();
    List<OrderResponseDto> getAllPendingOrders();
    void updateOrderStatus(Long orderId,String orderStatus);
}
