package com.involves.audit.services.form;

public class FormCreatedEvent {
	
	private Form form;
	private String username;
	
	public FormCreatedEvent(String username, Form form) {
		this.username = username;
		this.form = form;
	}

	public Form getForm() {
		return form;
	}

	public String getUsername() {
		return username;
	}
}
