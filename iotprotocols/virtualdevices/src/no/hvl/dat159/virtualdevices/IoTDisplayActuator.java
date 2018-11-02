package no.hvl.dat159.virtualdevices;

import java.net.*;
import java.nio.ByteBuffer;

public class IoTDisplayActuator {

	public static void main(String[] args) {

		UDPReceiver receiver = null;

		try {

			Display display = new Display();

			receiver = new UDPReceiver();

			while (true) {

				byte[] message = new byte[4];

				boolean ok = receiver.receive(message);
				int temp = ByteBuffer.wrap(message).getInt();

				if (ok) {
					display.write(Integer.toString(temp));
				} else
					display.write("Receive Error");

			}
		} catch (SocketException ex) {
			System.out.println("IoT Display: " + ex.getMessage());
			ex.printStackTrace();

		}

		finally {
			if (receiver != null) {
				receiver.stop();

			}
		}
	}
}
