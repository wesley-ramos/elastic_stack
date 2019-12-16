package com.involves.audit.services.custumer;

public class CustumerCreatedEvent {
	
	private Custumer custumer;
	private String username;
	
	public CustumerCreatedEvent(String username, Custumer custumer) {
		this.username = username;
		this.custumer = custumer;
	}

	public Custumer getCustumer() {
		return custumer;
	}

	public String getUsername() {
		return username;
	}
}
