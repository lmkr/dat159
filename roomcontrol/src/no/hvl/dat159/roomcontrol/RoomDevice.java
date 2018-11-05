package no.hvl.dat159.roomcontrol;

public class RoomDevice {

	public static void main(String[] args) {
		
		Room room = new Room(20);
		
		TemperatureSensor sensor = new TemperatureSensor(room);
		
		MQTTPubTemperature sensorpub = new MQTTPubTemperature(sensor);
		
		try {
			
			Thread temppublisher = new Thread(sensorpub);
			
			temppublisher.start();
			
			temppublisher.join();
			
		} catch (Exception ex) {
			
			System.out.println("RoomDevice: " + ex.getMessage());
			ex.printStackTrace();
		}
		


	}

}
