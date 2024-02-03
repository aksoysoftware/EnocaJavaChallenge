package com.enoca.challenge.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enoca.challenge.data.entity.Customer;
import com.enoca.challenge.data.entity.Product;
import com.enoca.challenge.data.repository.CustomerRepository;
import com.enoca.challenge.data.repository.ProductRepository;

@Component
public class ApplicationStartup implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        
        saveProducts();
        saveCustomer();
        
    }

    private void saveProducts() {
       
        for (int i = 1; i <= 5; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10.0 * i);
            product.setStock(100);
            product.setCreateDate(LocalDateTime.now());
            productRepository.save(product);
        }
    }
    private void saveCustomer() {
    	
    	Customer customer = new Customer();
    	customer.setEmail("example.com");
    	customer.setName("example");
    	customer.setPhoneNumber("123456789");
    	
    	customerRepository.save(customer);
    	
    }
    
}
