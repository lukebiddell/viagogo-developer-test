package main;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Random r;

		if (args.length == 1) {
			r = new Random(Long.parseLong(args[0]));
		} else {
			r = new Random(256245642);
		}
		World world = new World(r);

		Scanner s = new Scanner(System.in);
		boolean validInput = false;
		String[] inputs = null;

		while (!validInput) {
			System.out.println("Please Input Coordinates:");
			String input = s.nextLine();
			inputs = input.split(",");
			validInput = inputs.length == 2; // TODO Check if is int
		}
		s.close();

		int x = Integer.parseInt(inputs[0].trim());
		int y = Integer.parseInt(inputs[1].trim());

		Coordinates c = new Coordinates(x, y);

		Set<Event> nearestEvents = world.getNearestEvents(c, 3);

		System.out.println("Closest Events to " + c + ":");

		for (Event e : nearestEvents) {
			String eventData = "Event " + e.getFormattedID() + " - ";
			if(e.hasTicket()){
				eventData += e.getCheapestTicket().getFormattedPrice();
			} else {
				eventData += "Tickets sold out";
			}
			
			eventData += ", Distance " + e.distanceTo(c);
			
			System.out.println(eventData);
		}
	}

}
