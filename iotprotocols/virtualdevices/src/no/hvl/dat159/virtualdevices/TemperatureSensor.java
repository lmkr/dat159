package no.hvl.dat159.virtualdevices;

public class TemperatureSensor {

	static final int RANGE = 100;
	
	public int readTemp () {
		
		long seconds = System.currentTimeMillis();
		
		double temp = RANGE * Math.sin(seconds / 1000);
		
		return (int) Math.ceil(temp);
	}
}
