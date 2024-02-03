package com.enoca.challenge.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
