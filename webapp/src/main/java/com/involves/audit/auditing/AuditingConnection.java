package com.involves.audit.auditing;

import java.net.DatagramPacket;

public interface AuditingConnection {
	
	public void send(DatagramPacket packet) throws Exception;
}
