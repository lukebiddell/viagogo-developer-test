package main;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class stores events and ensures no 2 events are held at same coordinates
 * with method for finding nearest events amongst others.
 */
public class World {

	/** The set of events stored in world. */
	public HashSet<Event> events = new HashSet<Event>();

	/** Instantiates a new world. */
	public World() {

	}

	/**
	 * Adds the event if an event doesn't already exist in world with same
	 * coordinates.
	 *
	 * @param event
	 *            the event to add
	 * @throws IllegalArgumentException
	 *             if world already contains event with the same coordinates
	 */
	public void addEvent(Event event) {
		if (containsCoordinates(event)) {
			throw new IllegalArgumentException("Event already exists at the event's coordinates: " + event.getCoords());
		} else {
			events.add(event);
		}
	}

	/**
	 * Checks if event with same coordinates already exists in events.
	 *
	 * @param e1
	 *            the event to check if coordinates exist
	 * @return true, if events contains same coordinates
	 */
	private boolean containsCoordinates(Event e1) {
		for (Event e2 : events)
			if (e1.getCoords().equals(e2.getCoords()))
				return true;
		return false;
	}

	/**
	 * Gets the nearest events.
	 *
	 * @param coords
	 *            the coordinates of the point you're finding the nearest events
	 *            to
	 * @param noEvents
	 *            the number of nearest events to return in the set
	 * @return the nearest events to coordinates
	 */
	public Set<Event> getNearestEvents(Coordinates coords, int noEvents) {
		/*
		 * Comparator for comparing events by distance to coordinates given
		 * above. Returns 1 if equal distances as otherwise they would be
		 * considered equal, and the event won't be added.
		 */
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
				// remove old event and replace with shorter distance event
				nearestEvents.pollLast();
				nearestEvents.add(event);
			}
		}

		return nearestEvents;
	}

}
