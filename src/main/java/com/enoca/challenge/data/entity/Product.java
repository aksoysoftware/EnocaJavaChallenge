package com.enoca.challenge.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Product extends BaseEntity{

	private String name;
	
	
	private double price;
    private int stock;
    
    
    private LocalDateTime createDate;
  
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
	
	
	
	
  
	
    
    
    
    
}