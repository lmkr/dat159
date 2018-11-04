package no.hvl.dat159.roomcontrol;

public class SimpleController implements Runnable {

	Heating heater;
	
	public SimpleController(Heating heater) {
		this.heater = heater;
	}
	
	public void run() {
	
		System.out.println("Controller running");

		try {
			
			for (int i = 1; i<=6; i++) {

				// receive from CloudMQTT
				heater.write(true);
				
				Thread.sleep(5000);

				heater.write(false);

				Thread.sleep(5000);

				// determine whether to publish on CloudMQTT
			}

		} catch (Exception ex) {
			System.out.println("Controller: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		System.out.println("Controller stopping");

	}
}
