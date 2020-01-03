package com.involves.audit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageSerializerJackson implements MessageSerializer {
	
	private ObjectMapper mapper;
	
	@Autowired
	public MessageSerializerJackson(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public <T> String serialize(T message) throws Exception {
		return mapper.writeValueAsString(message);
	}

	@Override
	public <T> T deserialize(String message, Class<T> clazz) throws Exception {
		return mapper.readValue(message, clazz);
	}
}
