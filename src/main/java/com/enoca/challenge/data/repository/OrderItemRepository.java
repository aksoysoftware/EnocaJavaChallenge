package com.enoca.challenge.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
