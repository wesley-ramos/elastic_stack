package com.involves.audit.services.auditing;

import java.util.Map;

public class Auditing {
	
	private Map<String, Object> auditing;
	
	public Auditing(Map<String, Object> auditing) {
		this.auditing = auditing;
	}
	
	public void setFunctionality(String functionality) {
		auditing.put("functionality", functionality);
	}
	
	public void setApplication(String application) {
		auditing.put("application", application);
	}
	
	public Map<String, Object> getData() {
		return auditing;
	}
}
