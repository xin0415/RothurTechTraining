package com.homework.training.mapper;

import com.homework.training.dto.OrderDto;
import com.homework.training.entity.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getPurchase_date(),
                order.getPurchases()
        );
    }
    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getPurchase_date(),
                orderDto.getPurchases()
        );
    }
}
