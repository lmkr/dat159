package no.hvl.dat159.virtualdevices;

public class TemperatureSensor {

	static final int RANGE = 100;
	
	public int readTemp () {
		
		long seconds = System.currentTimeMillis() / 1000;
		
		double temp = RANGE * Math.sin(seconds);
		
		return (int) Math.ceil(temp);
	}
}
