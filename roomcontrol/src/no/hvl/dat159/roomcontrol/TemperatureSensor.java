package no.hvl.dat159.roomcontrol;

public class TemperatureSensor implements Runnable {

	private Room room;

	public TemperatureSensor(Room room) {

		this.room = room;
	}

	public double read() {

		return room.sense();
	}

	public void run() {

		System.out.println("Sensor running");

		try {
			
			for (int i = 1; i<=60; i++) {

				double temperature = read();

				// publish to CloudMQTT
				System.out.println("TEMPERATURE:" + temperature);

				Thread.sleep(1000);

			}

		} catch (Exception ex) {
			System.out.println("TemperatureSensor: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		System.out.println("Sensor stopping");

	}
}
