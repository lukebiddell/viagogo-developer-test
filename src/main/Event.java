package main;

import java.math.BigDecimal;
import java.util.TreeSet;

public class Event {

	private static int nextID = 1;
	private final int id;
	private final Coordinates coords;
	private TreeSet<Ticket> tickets;

	public Event(int x, int y) {
		id = nextID++;
		coords = new Coordinates(x, y);
		tickets = new TreeSet<Ticket>();

		tickets.add(new Ticket(new BigDecimal(500.36)));
		tickets.add(new Ticket(new BigDecimal(100.3677)));
		tickets.add(new Ticket(new BigDecimal(1000.3)));
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

}