package com.homework.training.controller;

import com.homework.training.dto.OrderDto;
import com.homework.training.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder=orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        List<OrderDto> orderDtos=orderService.findAllOrders();
        return ResponseEntity.ok(orderDtos);
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable("id") Long orderId) {
        OrderDto getOrder= orderService.findOrderById(orderId);
        return ResponseEntity.ok(getOrder);
    }
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder=orderService.updateOrder(orderId,orderDto);
        return ResponseEntity.ok(updatedOrder);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }

}
