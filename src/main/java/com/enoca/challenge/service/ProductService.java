package com.enoca.challenge.service;

import com.enoca.challenge.controller.DTO.CreateProductRequest;
import com.enoca.challenge.data.entity.Product;

public interface ProductService {
    Product createProduct(CreateProductRequest product);

    void deleteProduct(Long productId);
    Product getProduct(Long productId);
	



	Product updateProduct(Long productId, CreateProductRequest updatedProduct);
}
