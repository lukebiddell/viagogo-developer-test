package main;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class World {

	public HashSet<Event> events = new HashSet<Event>();

	public World() {

	}

	public World(Random r) {
		HashSet<Coordinates> usedCoords = new HashSet<Coordinates>();

		for (int i = 0; i <= 100; i++) {
			int x = 0;
			int y = 0;
			boolean duplicateCoords = true;
			while (duplicateCoords) {
				x = r.nextInt(21) - 10;
				y = r.nextInt(21) - 10;
				duplicateCoords = usedCoords.contains(new Coordinates(x, y));
			}
			usedCoords.add(new Coordinates(x, y));
			Event e = new Event(x, y);

			int noTickets = r.nextInt(10);

			for (int j = 0; j < noTickets; j++) {
				double price = r.nextDouble() * 99 + 0.01;
				e.addTicket(new Ticket(new BigDecimal(price)));
			}

			addEvent(e);
		}
	}

	public void addEvent(Event event) {
		if (containsCoordinates(event)) {
			throw new IllegalArgumentException("Coordinates already contain an event: " + event.getCoords());
		} else {
			events.add(event);
		}

	}

	public Set<Event> getNearestEvents(Coordinates coords, int noEvents) {
		Comparator<Event> eventComparator = new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {

				// compare distance to coords
				int comparison = Integer.compare(e1.distanceTo(coords), e2.distanceTo(coords));

				// if equal distances
				if (comparison == 0) {
					comparison = 1;
				}

				return comparison;
			}
		};

		TreeSet<Event> nearestEvents = new TreeSet<Event>(eventComparator);

		for (Event event : events) {
			if (nearestEvents.size() < noEvents) {
				nearestEvents.add(event);
			} else if (event.distanceTo(coords) < nearestEvents.last().distanceTo(coords)) {
				nearestEvents.pollLast();
				nearestEvents.add(event);
			}
		}

		return nearestEvents;
	}

	private boolean containsCoordinates(Event e1) {
		for (Event e2 : events)
			if (e1.getCoords().equals(e2.getCoords()))
				return true;
		return false;
	}

}
