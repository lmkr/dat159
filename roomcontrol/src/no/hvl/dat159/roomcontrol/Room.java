package no.hvl.dat159.roomcontrol;

public class Room {

	private int tempstate;
	private static double RATE = .0001; // change in temperature per time unit

	private double temperature;
	private long lastsense;

	public Room(int starttemp) {
		tempstate = -1;
		temperature = starttemp;
		lastsense = System.currentTimeMillis();
	}

	synchronized public double sense() {

		long timenow = System.currentTimeMillis();
		long timeinterval = timenow - lastsense;

		temperature = temperature + (RATE * tempstate * timeinterval);

		return temperature;
	}

	synchronized public void actuate(boolean newstate) {

		sense();

		if (newstate)
			tempstate = 1;
		else
			tempstate = -1;
	}
}
