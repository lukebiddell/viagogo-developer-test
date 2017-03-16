package main;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Event event = new Event(5,-5);
		
		World world = new World();
		world.addEvent(event);
	}

}
