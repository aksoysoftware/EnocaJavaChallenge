package com.enoca.challenge.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomer_Id(Long customerId);
}
