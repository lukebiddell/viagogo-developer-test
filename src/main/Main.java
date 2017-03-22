package main;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * This class is used to take a user input of coordinates, and return the 5
 * closest events to that coordinates, listing each event's ID, cheapest ticket
 * price and distance from user coordinates.
 */
public class Main {

	/**
	 * The main method which takes a user input of coordinates, and returns the
	 * 3 closest events to that coordinates, listing each event's ID, cheapest
	 * ticket price and distance from user coordinates.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Random r;

		if (args.length == 1) {
			r = new Random(Long.parseLong(args[0]));
		} else {
			r = new Random();
		}

		World world = randomWorld(r, 25, 10, 99);

		Coordinates c = getUserCoordinates();

		printNearestEvents(world.getNearestEvents(c, 5), c);
	}

	/**
	 * Gets the user's coordinates, entered using the form x,y.
	 *
	 * @return the user's coordinates
	 */
	private static Coordinates getUserCoordinates() {
		Scanner s = new Scanner(System.in);

		boolean validInput = false;
		String[] inputs = null;

		while (!validInput) {
			System.out.print("Please Input Coordinates: ");

			String input = s.nextLine();
			inputs = input.split(",");

			validInput = inputs.length == 2;
		}

		s.close();

		int x = Integer.parseInt(inputs[0].trim());
		int y = Integer.parseInt(inputs[1].trim());

		return new Coordinates(x, y);
	}

	/**
	 * Prints the nearest events.
	 *
	 * @param nearestEvents
	 *            the nearest events
	 * @param c
	 *            the c
	 */
	private static void printNearestEvents(Set<Event> nearestEvents, Coordinates c) {
		System.out.println("Closest Events to " + c + ":");

		for (Event e : nearestEvents) {
			String eventData = "Event " + e.getFormattedID() + " - ";
			if (e.hasTicket()) {
				eventData += e.getCheapestTicket().getFormattedPrice();
			} else {
				eventData += "Tickets sold out";
			}

			eventData += ", Distance " + e.distanceTo(c);

			System.out.println(eventData);
		}
	}

	/**
	 * Creates a world with random seed data using given random.
	 *
	 * @param r
	 *            the random used to generate random seed data
	 * @param noEvents
	 *            the number of events to generate
	 * @param maxNoTickets
	 *            the max number tickets per event to generate
	 * @param maxTicketPrice
	 *            the max ticket price to generate
	 * @return the world with random seed data
	 */
	private static World randomWorld(Random r, int noEvents, int maxNoTickets, double maxTicketPrice) {
		World world = new World();
		HashSet<Coordinates> usedCoords = new HashSet<Coordinates>();

		for (int i = 0; i < noEvents; i++) {
			int x = 0;
			int y = 0;
			boolean duplicateCoords = true;

			while (duplicateCoords) {
				x = r.nextInt(21) - 10;
				y = r.nextInt(21) - 10;
				duplicateCoords = usedCoords.contains(new Coordinates(x, y));
			}

			usedCoords.add(new Coordinates(x, y));
			Event event = new Event(x, y);

			int noTickets = r.nextInt(maxNoTickets);

			for (int j = 0; j < noTickets; j++) {
				double price = r.nextDouble() * maxTicketPrice + 0.01;
				event.addTicket(new Ticket(new BigDecimal(price)));
			}

			world.addEvent(event);
		}

		return world;
	}
}
