package no.hvl.dat159.roomcontrol;

public class Heating {

	private Room room;
		
	public Heating (Room room) {
		this.room = room;
	}
	
	public void write (boolean newvalue) {
		room.actuate(newvalue);
	}
	
}
