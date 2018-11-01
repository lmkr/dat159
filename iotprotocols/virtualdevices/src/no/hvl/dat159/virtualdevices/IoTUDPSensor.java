package no.hvl.dat159.virtualdevices;

import java.io.*;
import java.net.*;

public class IoTUDPSensor {

	public static void main(String[] args) {

		String hostname = "localhost";
        int port = Integer.parseInt("8042");
        DatagramSocket socket = null;
        
        try {
        	
            InetAddress address = InetAddress.getByName(hostname);
            socket = new DatagramSocket();
 
            while (true) {
 
            	System.out.print("C");
                DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
                socket.send(request);
                System.out.print("C!");
                Thread.sleep(10000);
            }
 
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
        	if (socket != null) {
        		socket.close();
        	}
        }
        
       
	}

}
