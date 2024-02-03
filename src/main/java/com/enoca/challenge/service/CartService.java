package com.enoca.challenge.service;

import com.enoca.challenge.controller.DTO.AddProductRequest;
import com.enoca.challenge.controller.DTO.RemoveProductRequest;
import com.enoca.challenge.data.entity.Cart;

public interface CartService {
	
	
	Cart getCart(Long id);
	Cart updateCart(Cart cart);
	void emptyCart(Long id);
	
	
    void updateCartTotalPrice(Cart cart);
    Cart addProductToCart(Long customerId, AddProductRequest addProductRequest);
	Cart removeProductFromCart(Long customerId, RemoveProductRequest removeProductRequest);
	

	
	
	
    
	
}