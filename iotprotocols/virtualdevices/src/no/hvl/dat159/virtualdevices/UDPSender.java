package no.hvl.dat159.virtualdevices;

import java.io.*;
import java.net.*;

public class UDPSender {

	private DatagramSocket socket = null;
	private InetAddress address;
	private int port;
	
	public UDPSender() throws SocketException,UnknownHostException {
	    
		 socket = new DatagramSocket();
		 address = InetAddress.getByName(Configuration.server);
		 port = Configuration.serverport;
		 
	}
	
	public boolean send(byte[] message) {

        boolean sent = true;
        try {
        
        	DatagramPacket request = new DatagramPacket(message, message.length, address, port);
        	System.out.println("!");
        	socket.send(request);
			System.out.println(".");
        
        } catch (IOException ex) {
            System.out.println("Client send: " + ex.getMessage());
            ex.printStackTrace();
            sent = false;
        }
        
        return sent;
	}
	
	public void stop() {
		
		if (socket != null) {
			socket.close();
		}
		
	}
}