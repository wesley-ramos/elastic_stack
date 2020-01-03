package com.involves.audit.auditing;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.springframework.stereotype.Service;

@Service
public class AuditingConnectionOnLogstash implements AuditingConnection {
	
	private DatagramSocket socket;
	
	public AuditingConnectionOnLogstash() throws Exception {
		socket = new DatagramSocket();
	}
	
	@Override
	public void send(DatagramPacket packet) throws Exception {
		socket.send(packet);
	}
}
