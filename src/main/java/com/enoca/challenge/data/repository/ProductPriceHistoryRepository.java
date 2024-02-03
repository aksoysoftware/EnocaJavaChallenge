package com.enoca.challenge.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.data.entity.ProductPriceHistory;

public interface ProductPriceHistoryRepository extends JpaRepository<ProductPriceHistory, Long> {

	
}
