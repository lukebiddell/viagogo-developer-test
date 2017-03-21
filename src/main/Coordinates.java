package main;

public class Coordinates {

	private final int x;
	private final int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distanceTo(Coordinates c) {
		return Math.abs(x - c.getX()) + Math.abs(y - c.getY());
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	
	public int hashCode() {
		//Cantor pairing function
		//https://en.wikipedia.org/wiki/Pairing_function#Cantor_pairing_function
		
		int h = 1/2 * (x + y) * (x + y + 1) + y;
		
		if (h >= 0){
			return h * 2;
		} else {
			return -h * 2 - 1;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Coordinates) {
			Coordinates c = (Coordinates) o;
			return (x == c.x) && (y == c.y);
		} else {
			return false;
		}
	}
}
