package com.enoca.challenge.service;

import com.enoca.challenge.controller.DTO.AddCustomerRequest;
import com.enoca.challenge.data.entity.Customer;

public interface CustomerService {
	Customer addCustomer(AddCustomerRequest customer);
    Customer getCustomerById(Long customerId);
}
