package com.involves.audit.auditing;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.audit.configuration.AppConfiguration;

@Service
public class AuditingServiceOnLogstash implements AuditingService {
	
	private Logger logger = LoggerFactory.getLogger(AuditingServiceOnLogstash.class);
	
	private AuditingConnection connection;
	private LogstashMessageSpliter prepareMessage;

	@Autowired
	public AuditingServiceOnLogstash(AuditingConnection connection, LogstashMessageSpliter prepareMessage) {
		this.connection = connection;
		this.prepareMessage = prepareMessage;
	}

	@Override
	public void audit(String functionality, Auditing auditing) {
		
		try {
			
			InetAddress address = InetAddress.getByName("localhost");
			int port = 8090;
			
			auditing.setFunctionality(functionality);
			auditing.setApplication(AppConfiguration.APPLICATION_NAME);
			
			List<DatagramPacket> packets = prepareMessage.split(address, port, auditing);
			
			for (DatagramPacket packet : packets) {
				connection.send(packet);
			}
			
		} catch (Exception ex) {
			logger.error("failed to send message to Logstash", ex);
		}
	}
}
