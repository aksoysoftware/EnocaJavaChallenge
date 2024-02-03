package com.enoca.challenge.service;

import com.enoca.challenge.data.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
}
