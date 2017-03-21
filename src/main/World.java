package main;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class World {

	// private Map<Coordinates, Event> map;
	public HashSet<Event> events;

	public World() {
		// map = new HashMap<Coordinates, Event>();
		events = new HashSet<Event>();
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	public Set<Event> getNearestEvents(Coordinates coords, int noEvents) {
		Comparator<Event> eventComparator = new Comparator<Event>() {
			public int compare(Event e1, Event e2) {

				// compare distance to coords
				int comparison = Integer.compare(e1.distanceTo(coords), e2.distanceTo(coords));

				// if equal distances
				if (comparison == 0) {

					// compare ticket price
					comparison = e1.getCheapestTicket().getPrice().compareTo(e2.getCheapestTicket().getPrice());

					// if still equal, consider e1 > e2
					if (comparison == 0) {
						comparison = 1;
					}
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
	
}
