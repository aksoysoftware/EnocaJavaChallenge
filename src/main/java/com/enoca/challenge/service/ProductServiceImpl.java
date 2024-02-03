package com.enoca.challenge.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.challenge.controller.DTO.CreateProductRequest;
import com.enoca.challenge.data.entity.Product;
import com.enoca.challenge.data.entity.ProductPriceHistory;
import com.enoca.challenge.data.repository.ProductPriceHistoryRepository;
import com.enoca.challenge.data.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private ProductPriceHistoryRepository productPriceHistoryRepository;
    
    
    @Override
    public Product createProduct(CreateProductRequest createProduct) {
    	Product product = new Product();
        product.setName(createProduct.getName());
        product.setPrice(createProduct.getPrice());
        product.setStock(createProduct.getStock());
        product.setCreateDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, CreateProductRequest updatedProduct) {
        
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("not found: " + productId));
        
     
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());

        
        Product savedProduct = productRepository.save(existingProduct);

        ProductPriceHistory priceHistory = new ProductPriceHistory();
        priceHistory.setProduct(savedProduct);
        priceHistory.setPrice(updatedProduct.getPrice());  
        priceHistory.setQuantity(updatedProduct.getStock());  
        priceHistory.setChangeData(LocalDateTime.now());
       

        productPriceHistoryRepository.save(priceHistory);
        
        
        return savedProduct;
    }



    @Override
    public void deleteProduct(Long productId) {
        
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}