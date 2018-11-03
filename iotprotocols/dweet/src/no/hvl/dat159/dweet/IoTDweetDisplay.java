package no.hvl.dat159.dweet;

public class IoTDweetDisplay {

	public static void main(String[] args) {

		try {

			Display display = new Display();

			DweetClient client = new DweetClient();

			for (int i = 0; i<10; i++) {

				System.out.print("?");
				String response = client.get();
				
				if (response != null) {
					display.write(response);
				} else {
					display.write("Error");
				}
			
				Thread.sleep(10000);

			}

		} catch (Exception ex) {
			System.out.println("DweetDisplay: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
