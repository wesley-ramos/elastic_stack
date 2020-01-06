package com.involves.audit.services.auditing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuditingConnectionOnLogstash implements AuditingConnection {
	
	private Logger logger = LoggerFactory.getLogger(AuditingConnectionOnLogstash.class);
	private DatagramSocket socket;

	@Override
	public void connect(String url, int port) throws Exception {
		InetAddress address = InetAddress.getByName(url);

		socket = new DatagramSocket();
		socket.connect(address, port);
	}

	@Override
	public void send(DatagramPacket packet) throws Exception {
		if(socket == null) {
			logger.warn("Logstash connection is down, please wait");
			return;
		}
		socket.send(packet);
	}
}
