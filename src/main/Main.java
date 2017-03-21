package main;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private final static int noCoordinates = 10;
	private final static int noTickets = 10;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		long seed = 45523524;
		Random r = new Random(seed);
		for (int i = 0; i < noCoordinates; i++) {

		}

		Event event1 = new Event(5, -5);
		Event event2 = new Event(1, 5);
		Event event3 = new Event(5, 9);
		Event event4 = new Event(-5, 5);

		event1.addTicket(new Ticket(new BigDecimal(20.2)));

		World world = new World();

		world.addEvent(event1);
		world.addEvent(event2);
		world.addEvent(event3);
		world.addEvent(event4);

		

		Scanner s = new Scanner(System.in);
		boolean validInput = false;
		String[] inputs = null;
		
		while(!validInput){
			System.out.println("Please Input Coordinates:");
			String input = s.nextLine();
			inputs = input.split(",");
			validInput = inputs.length == 2; //TODO Check if is int
		}
		s.close();

		
		int x = Integer.parseInt(inputs[0].trim());
		int y = Integer.parseInt(inputs[1].trim());

		Coordinates c = new Coordinates(x, y);

		Set<Event> nearestEvents = world.getNearestEvents(c, 3);

		System.out.println("Closest Events to " + c + ":");
		
		for (Event e : nearestEvents) {
			System.out.println("Event " + e.getFormattedID() + " - " + e.getCheapestTicket().getFormattedPrice() + ", Distance " + e.distanceTo(c));
		}
	}

}
