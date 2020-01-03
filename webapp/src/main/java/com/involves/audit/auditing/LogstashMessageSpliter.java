package com.involves.audit.auditing;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.audit.utils.MessageSerializer;

@Service
public class LogstashMessageSpliter {
	
	private Integer SIZE_LIMIT = 30;
	private MessageSerializer serializer;
	
	@Autowired
	public LogstashMessageSpliter(MessageSerializer serializer) {
		this.serializer = serializer;
	}
	
	public List<DatagramPacket> split(InetAddress address, int port, Auditing auditing) throws Exception{
		
		byte[] message = serializer.serialize(auditing.getData()).getBytes();
		
		if(message.length <= SIZE_LIMIT) {
			return Arrays.asList(new DatagramPacket(message, message.length, address, port));
		}
		
		List<DatagramPacket> messages = new  ArrayList<>();
		
		int offset = 0;
		int length = SIZE_LIMIT;
		
		while (offset < message.length) {	
			
			messages.add(new DatagramPacket(message, offset, length, address, port));
			
			offset += SIZE_LIMIT;
			length = Math.min(message.length - offset, SIZE_LIMIT);   
		}
		
		return messages;
	}
}
