package com.enoca.challenge.service;

import java.util.List;

import com.enoca.challenge.data.entity.Order;

public interface OrderService {
    List<Order> getOrdersByCustomerId(Long customerId);
    Order getOrder(Long orderId);
    Order placeOrder(Long cartId);
	Order placeOrderCustomer(Long customerId);
}
