package no.hvl.dat159.virtualdevices.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat159.virtualdevices.*;

class TestTemperatureSensor {

	@Test
	void test() throws InterruptedException {
		
		TemperatureSensor sensor = new TemperatureSensor();
		
		for (int i = 0; i<10; i++) {
			System.out.println("TEMPERATURE SENSOR READ: " + sensor.read());
			Thread.sleep(1000);
		}
	
		
	}
	

}
