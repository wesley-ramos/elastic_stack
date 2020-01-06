package com.involves.audit.services.auditing;

import java.net.DatagramPacket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.audit.configuration.AppConfiguration;
import com.involves.audit.services.serializer.MessageSerializer;

@Service
public class AuditingServiceOnLogstash implements AuditingService {
	
	private Logger logger = LoggerFactory.getLogger(AuditingServiceOnLogstash.class);
	
	private AuditingConnection connection;
	private MessageSerializer serializer;

	@Autowired
	public AuditingServiceOnLogstash(AuditingConnection connection, MessageSerializer serializer) {
		this.connection = connection;
		this.serializer = serializer;
	}

	@Override
	public void audit(String functionality, Auditing auditing) {
		
		try {
					
			auditing.setFunctionality(functionality);
			auditing.setApplication(AppConfiguration.APPLICATION_NAME);
			
			byte[] message = serializer.serialize(auditing.getData()).getBytes();
	
			connection.send(new DatagramPacket(message, message.length));
			
		} catch (Exception ex) {
			logger.error("failed to send message to Logstash", ex);
		}
	}
}
