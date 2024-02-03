package com.enoca.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.controller.DTO.AddProductRequest;
import com.enoca.challenge.controller.DTO.RemoveProductRequest;
import com.enoca.challenge.data.entity.Cart;
import com.enoca.challenge.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long customerId) {
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }

    @PatchMapping
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        Cart updatedCart = cartService.updateCart(cart);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{customerId}/empty")
    public ResponseEntity<Void> emptyCart(@PathVariable Long customerId) {
        cartService.emptyCart(customerId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{customerId}/addProduct")
    public ResponseEntity<Cart> addProductToCart(
            @PathVariable Long customerId,
            @RequestBody AddProductRequest addProductRequest) {
        Cart updatedCart = cartService.addProductToCart(customerId, addProductRequest);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{customerId}/removeProduct")
    public ResponseEntity<Cart> removeProductFromCart(
            @PathVariable Long customerId,
            @RequestBody RemoveProductRequest removeProductRequest) {
        Cart updatedCart = cartService.removeProductFromCart(customerId, removeProductRequest);
        return ResponseEntity.ok(updatedCart);
    }}