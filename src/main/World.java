package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class World {

	private Map<Coordinates, Event> map;

	public World() {
		map = new HashMap<Coordinates, Event>();
	}

	public void addEvent(Event event) {
		map.put(event.getCoords(), event);
	}

	public Queue<Event> getNearestEvents(int noEvents) {
		Queue<Event> nearestEvents = new LinkedList<Event>();
		
		while (nearestEvents.size() < noEvents) {
			nearestEvents.add(null);
		}

		return nearestEvents;

	}
}
