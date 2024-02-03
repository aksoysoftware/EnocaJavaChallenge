package com.enoca.challenge.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer getCustomerById(Long customerId);
}