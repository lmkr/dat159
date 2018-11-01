package no.hvl.dat159.virtualdevices;

import java.io.*;
import java.net.*;

public class IoTUDPServer {

	private static DatagramSocket socket;

	public IoTUDPServer(int port) throws SocketException {
		socket = new DatagramSocket(port);
	}

	public void run() throws IOException {
		
		System.out.println("Server running");
		while (true) {

			System.out.println("?");
			DatagramPacket request = new DatagramPacket(new byte[1], 1);
			socket.receive(request);
			System.out.println("R");

		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			IoTUDPServer server = new IoTUDPServer(8042);
		    server.run();
		    
		    } catch (Exception e) {
		    	e.printStackTrace();
		    } finally {
		    	if (socket != null) {
		    		socket.close();
		    	}
		    	System.out.println("Server stopped");
		    }
	}
}
