package com.enoca.challenge.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	 Cart findByCustomerId(Long customerId);
	
	 Cart getById(Long cartId);

	Cart getCartByCustomerId(Long customerId);
}
