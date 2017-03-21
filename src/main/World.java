package main;

import java.math.BigDecimal;
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
		TreeSet<Event> nearestEvents = new TreeSet<Event>(new Comparator<Event>() {
			public int compare(Event e1, Event e2) {
				int comparison = Integer.compare(e1.distanceTo(coords), e2.distanceTo(coords));
				if (comparison == 0){
					comparison = e1.getCheapestTicket().getPrice().compareTo(e2.getCheapestTicket().getPrice());
					
					if (comparison == 0){
						comparison = 1;
					}
				}
				
				return comparison;
			}
		});

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
