package main;

import java.util.TreeSet;

/**
 * This class is used for storing locations of the event and the set of tickets,
 * along with useful methods.
 */
public class Event {

	/** Static int that stores the ID of the next event. */
	private static int nextID = 1;

	/**
	 * The unique id of the event taken from value of nextID, which then
	 * increments nextID
	 */
	private final int id = nextID++;
	
	/** The coordinates of the event. */
	private final Coordinates coords;


	/** The auto sorted set of tickets for the event. */
	private TreeSet<Ticket> tickets = new TreeSet<Ticket>();

	/**
	 * Instantiates a new event with given coordinates.
	 *
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public Event(int x, int y) {
		coords = new Coordinates(x, y);
	}

	/**
	 * Adds the ticket to set of tickets.
	 *
	 * @param t
	 *            the ticket to add
	 */
	public void addTicket(Ticket t) {
		tickets.add(t);
	}

	/**
	 * Gets the distance from the given coordinates to this events coordinates.
	 *
	 * @param coords
	 *            the coords to find distance from
	 * @return the distance between these 2 coordinates
	 */
	public int distanceTo(Coordinates coords) {
		return this.coords.distanceTo(coords);
	}

	/**
	 * Gets the cheapest ticket.
	 *
	 * @return the cheapest ticket
	 */
	public Ticket getCheapestTicket() {
		if (tickets.isEmpty()) {
			return null;
		} else {
			return tickets.first();
		}
	}

	/**
	 * Gets the coords of this event.
	 *
	 * @return the coordinates
	 */
	public Coordinates getCoords() {
		return coords;
	}

	/**
	 * Gets the ID formatted to have leading zeroes so that ID has at least 3
	 * digits.
	 *
	 * @return the ID as string with leading zeroes
	 */
	public String getFormattedID() {
		return String.format("%03d", getID());
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return id;
	}

	/**
	 * Checks if event has any tickets.
	 *
	 * @return true, if has tickets
	 */
	public boolean hasTicket() {
		return (tickets.size() != 0);
	}

}