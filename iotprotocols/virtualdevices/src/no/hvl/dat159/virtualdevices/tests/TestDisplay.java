package no.hvl.dat159.virtualdevices.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat159.virtualdevices.Display;

class TestDisplay {

	@Test
	void test() {
		
		Display display = new Display();
		
		display.write("TEST MESSAGE");
	}

}
