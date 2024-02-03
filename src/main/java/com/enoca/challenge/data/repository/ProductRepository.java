package com.enoca.challenge.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.controller.DTO.CreateProductRequest;
import com.enoca.challenge.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findById(Long productId);

	Product save(CreateProductRequest product);
}