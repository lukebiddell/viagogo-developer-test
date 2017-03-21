package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Ticket implements Comparable<Ticket> {

	private BigDecimal price; // non-zero
	private static DecimalFormat decimalFormatter = new DecimalFormat("00.00");
	
	public Ticket(BigDecimal price) {
		if (price.doubleValue() <= 0) {
			throw new IllegalArgumentException("Price must be positive and non-zero: " + price);
		} else {
			this.price = price;
		}
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return price.setScale(2, RoundingMode.HALF_EVEN).toString();
	}

	@Override
	public int compareTo(Ticket t) {
		return price.compareTo(t.getPrice());
	}

	public String getFormattedPrice() {
		return ("$" + decimalFormatter.format(Double.parseDouble(toString())));
	}

}
