package com.involves.audit.services.serializer;


public interface MessageSerializer {
	
	public <T> String serialize(T message) throws Exception;
	
	public <T> T deserialize(String message, Class<T> clazz) throws Exception;
	
}
