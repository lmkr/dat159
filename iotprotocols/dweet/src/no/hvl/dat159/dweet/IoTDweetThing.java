package no.hvl.dat159.dweet;

public class IoTDweetThing {

	public static void main(String[] args) {

		try {

			TemperatureSensor sensor = new TemperatureSensor();

			DweetClient client = new DweetClient();

			for (int i = 0; i<10; i++) {

				int temp = sensor.read();

				System.out.print("!");
				
				if (client.publish(temp)) {
					System.out.println(temp);
				} else
					System.out.println("FAIL");
			
				Thread.sleep(10000);

			}

		} catch (Exception ex) {
			System.out.println("DweetThing: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
