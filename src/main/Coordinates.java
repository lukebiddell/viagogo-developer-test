package main;

/**
 * This class stores the x and y coordinates, and useful methods for comparing
 * coordinates.
 */
public class Coordinates {

	/** The x coordinate. */
	private final int x;

	/** The y coordinate. */
	private final int y;

	/**
	 * Instantiates a new coordinates at specified point.
	 *
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Finds the Manhattan distance between this and the specified coordinate.
	 *
	 * @param c
	 *            the coordinate to find the distance from
	 * @return the Manhattan distance between the coordinates
	 */
	public int distanceTo(Coordinates c) {
		return Math.abs(x - c.getX()) + Math.abs(y - c.getY());
	}

	/**
	 * Checks if the x and y of object and this have same coordinates
	 * 
	 * @param o
	 *            the object to compare
	 * @return true if object is instance of Coordinates and has same x and y
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Coordinates) {
			Coordinates c = (Coordinates) o;
			return (x == c.x) && (y == c.y);
		} else {
			return false;
		}
	}

	/**
	 * Gets the x coordinate.
	 *
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Calculates the hashcode for the coordinates using Cantor pairing function
	 * https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
	 * 
	 * @return unique hashcode of the coordinates
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int h = 1 / 2 * (x + y) * (x + y + 1) + y;

		if (h >= 0) {
			return h * 2;
		} else {
			return -h * 2 - 1;
		}
	}

	/**
	 * Returns the coordinates as string in the form (x,y).
	 * 
	 * @return coordinates in form (x,y)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
