package com.enoca.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.challenge.controller.DTO.AddCustomerRequest;
import com.enoca.challenge.data.entity.Customer;
import com.enoca.challenge.data.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private final CustomerRepository customerRepository;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(AddCustomerRequest customer) {
		   Customer newCustomer = new Customer();
	        newCustomer.setName(customer.getName());
	        newCustomer.setEmail(customer.getEmail());
	        newCustomer.setPhoneNumber(customer.getPhoneNumber());
		  return customerRepository.save(newCustomer);
	}
   @Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.getCustomerById(customerId);
	}

}