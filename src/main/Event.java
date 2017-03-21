package main;

import java.util.TreeSet;

public class Event {

	private static int nextID = 1;
	private final int id = nextID++;
	private final Coordinates coords;
	private TreeSet<Ticket> tickets = new TreeSet<Ticket>();

	public Event(int x, int y) {
		coords = new Coordinates(x, y);		
	}

	public Ticket getCheapestTicket() {
		if (tickets.isEmpty()) {
			return null;
		} else {
			return tickets.first();
		}
	}

	public int distanceTo(Coordinates coords) {
		return this.coords.distanceTo(coords);
	}

	public Coordinates getCoords() {
		return coords;
	}

	public int getID() {
		return id;
	}

	public String getFormattedID() {
		return String.format("%03d", getID());
	}
	
	public void addTicket(Ticket t) {
		tickets.add(t);
	}
	
	public boolean hasTicket() {
		return (tickets.size() != 0);
	}

	/*@Override
	public boolean equals(Object o) {
		if (o instanceof Event) {
			Event e = (Event) o;
			return (getCoords() == e.getCoords());
		} else {
			return false;
		}
	}*/
}