package no.hvl.dat159.virtualdevices;

import java.net.*;
import java.nio.ByteBuffer;

public class IoTTemperatureSensor {

	public static void main(String[] args) {

		try {

			TemperatureSensor sensor = new TemperatureSensor();

			UDPSender sender = new UDPSender();

			while (true) {

				int temp = sensor.readTemp();

				// TODO: convert
				byte[] message = ByteBuffer.allocate(4).putInt(temp).array();

				boolean ok = sender.send(message);

				if (!ok) {
					System.out.println("Send Error");
				}

				Thread.sleep(10000);

			}

		} catch (Exception ex) {
			System.out.println("IoT Temperature Sensor: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
