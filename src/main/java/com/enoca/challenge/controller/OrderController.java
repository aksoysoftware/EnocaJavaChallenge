package com.enoca.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.data.entity.Order;
import com.enoca.challenge.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder/{cartId}")
    public ResponseEntity<String> placeOrder(@PathVariable Long cartId) {
        Order placedOrder = orderService.placeOrder(cartId);

        if (placedOrder != null) {
            
            return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to place order");
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }
    @PostMapping("/placeOrderByCustomer/{customerId}")
    public ResponseEntity<String> placeOrderByCustomer(@PathVariable Long customerId) {
        Order placedOrder = orderService.placeOrderCustomer(customerId);

        if (placedOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Order successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to place order");
        }
    }


   

}