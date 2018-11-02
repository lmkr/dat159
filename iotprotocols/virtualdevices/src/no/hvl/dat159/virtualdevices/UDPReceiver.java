package no.hvl.dat159.virtualdevices;

import java.io.*;
import java.net.*;

public class UDPReceiver {

	private DatagramSocket socket;

	public UDPReceiver() throws SocketException {
		socket = new DatagramSocket(Configuration.serverport);
	}

	public boolean receive(byte[] message) {

		boolean received = true;
		
		DatagramPacket request = new DatagramPacket(message, message.length);
		System.out.println("?");

		try {
			socket.receive(request);
			System.out.println(".");
		} catch (IOException ex) {
			received = false;
		}
		
		return received;
	}
	
	public void stop() {
		if (socket != null) {
			socket.close();
		}
	}
}
