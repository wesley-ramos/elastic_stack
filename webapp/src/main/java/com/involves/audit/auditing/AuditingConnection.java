package com.involves.audit.auditing;

import java.net.DatagramPacket;

public interface AuditingConnection {
	
	public void connect(String URL, int port) throws Exception;
	public void send(DatagramPacket packet) throws Exception;
}
