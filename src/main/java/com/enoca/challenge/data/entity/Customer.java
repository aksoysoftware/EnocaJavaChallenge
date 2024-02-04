package com.enoca.challenge.data.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer extends BaseEntity {
	
    private String name;
    private String email;
	private String phoneNumber;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

	@JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
   
    
    public Customer() {
		
	}
	public Customer(Long id, String name, String email,String phoneNumber) {
		
		this.name = name;
		this.email = email;
		this.phoneNumber=phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Cart getCart() {
		return cart;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
