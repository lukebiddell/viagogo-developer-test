package main;

import java.util.TreeSet;

public class Event {

	private int id;
	private Coordinates coords;
	private TreeSet<Ticket> tickets;

	public Event(int x, int y) {
		coords = new Coordinates(x, y);
		tickets = new TreeSet<Ticket>();
	}

	public Ticket getCheapestTicket() {
		return tickets.first();
	}

	public int getManDistance(Event event) {
		return 0;
	}

	public Coordinates getCoords() {
		return coords;
	}

	public int getID() {
		return id;
	}
	
}