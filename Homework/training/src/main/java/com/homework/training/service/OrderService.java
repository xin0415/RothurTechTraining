package com.homework.training.service;

import com.homework.training.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(Long orderId, OrderDto orderDto);
    List<OrderDto> findAllOrders();
    OrderDto findOrderById(Long id);
    void deleteOrderById(Long id);
}
