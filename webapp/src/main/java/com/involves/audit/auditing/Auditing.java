package com.involves.audit.auditing;

import java.util.Map;

public class Auditing {
	
	private Map<String, Object> auditing;
	
	public Auditing(Map<String, Object> auditing) {
		this.auditing = auditing;
	}

	public Map<String, Object> getAuditing() {
		return auditing;
	}
}
