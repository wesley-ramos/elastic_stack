package com.involves.audit.services.customer;

public class CustomerCreatedEvent {
	
	private Customer customer;
	private String username;
	
	public CustomerCreatedEvent(String username, Customer customer) {
		this.username = username;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getUsername() {
		return username;
	}
}
