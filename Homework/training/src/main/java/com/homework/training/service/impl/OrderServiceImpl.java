package com.homework.training.service.impl;

import com.homework.training.dto.OrderDto;
import com.homework.training.entity.Order;
import com.homework.training.entity.OrderProduct;
import com.homework.training.entity.Product;
import com.homework.training.exception.ResourceNotFoundException;
import com.homework.training.mapper.OrderMapper;
import com.homework.training.repository.OrderProductRepository;
import com.homework.training.repository.OrderRepository;
import com.homework.training.repository.ProductRepository;
import com.homework.training.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private OrderProductRepository orderProductRepository;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public OrderDto createOrder(OrderDto orderDto) {
        Order createdOrder = OrderMapper.mapToOrder(orderDto);
        createdOrder.setPurchase_date(new Date());
        List<OrderProduct> purchases=createdOrder.getPurchases();
        purchases.forEach((orderProduct -> {
            Product product=productRepository.findById(orderProduct.getProduct().getId()).get();
            orderProduct.setProduct(product);
            orderProduct.setOrder(createdOrder);
        }));
        orderRepository.save(createdOrder);
        return OrderMapper.mapToOrderDto(createdOrder);
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        Order updatedOrder = OrderMapper.mapToOrder(orderDto);
        List<OrderProduct> purchasesToRemove=order.getPurchases();
        List<OrderProduct> purchases=updatedOrder.getPurchases();
        purchases.forEach(orderProduct -> {
            Product product=productRepository.findById(orderProduct.getProduct().getId()).get();
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
        });
        if(purchases.size()>0){
            purchasesToRemove=purchasesToRemove.stream().filter(orderProduct ->{
                return !purchases.contains(orderProduct);
            }).collect(Collectors.toList());
        }
        order.setPurchases(purchases);
        Order updated = orderRepository.save(order);
        deleteOrderProducts(purchasesToRemove);
        return OrderMapper.mapToOrderDto(updated);
    }

    private void deleteOrderProducts(List<OrderProduct> purchasesToRemove) {
        orderProductRepository.deleteAll(purchasesToRemove);
    }

    @Override
    public List<OrderDto> findAllOrders() {
        List<Order> orders=orderRepository.findAll();
        return orders.stream().map(order -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(Long id) {
        Order order=orderRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Order is not exists with given id: " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        Order order=orderRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Order is not exists with given id: " + id));
        orderRepository.delete(order);
    }
}
