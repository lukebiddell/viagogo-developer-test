package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket implements Comparable<Ticket> {

	private BigDecimal price; // non-zero

	public Ticket(BigDecimal price) {
		if (price == null || price.doubleValue() <= 0){
			throw new IllegalArgumentException("Price must be positive and non-zero: " + price);
		}
		
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String toString() {
		return price.setScale(2, RoundingMode.HALF_EVEN).toString();
	}

	@Override
	public int compareTo(Ticket t) {
		return price.compareTo(t.getPrice());
	}

}
