package com.involves.audit.services.auditing;

import java.util.HashMap;
import java.util.Map;

public class AuditingBuilder {
	
	private Map<String, Object> fields = new HashMap<>();
	
	public static AuditingBuilder aAuditing() {
		return new AuditingBuilder();
	}
	
	public AuditingBuilder withField(String key, Object value) {
		fields.put(key, value);
		return this;
	}
	
	public AuditingBuilder withEncryptedField(String key, Object value) {
		fields.put(key, value);
		return this;
	}
	
	public Auditing build() {
		return new Auditing(fields);
	}
}
