package com.enoca.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.controller.DTO.AddCustomerRequest;
import com.enoca.challenge.data.entity.Customer;
import com.enoca.challenge.service.CustomerServiceImpl;
import com.enoca.challenge.service.OrderServiceImp;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private final CustomerServiceImpl customerService;

	
    
    
    public CustomerController(CustomerServiceImpl customerService, OrderServiceImp orderService) {
		super();
		this.customerService = customerService;
		
	}

	@PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody AddCustomerRequest customer) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        Customer addedCustomer = customerService.addCustomer(newCustomer);
        return ResponseEntity.ok(addedCustomer);
    }
    
	 @GetMapping("/{customerId}")
	    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
	        Customer customer = customerService.getCustomerById(customerId);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
    
    
}