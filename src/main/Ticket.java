package main;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * This class contains the price of the ticket, along with useful methods for
 * displaying and comparing.
 */
public class Ticket implements Comparable<Ticket> {

	/**
	 * The decimal format for displaying price to 2 decimal places with leading
	 * zeroes up to 2 digits.
	 */
	private static DecimalFormat decimalFormatter = new DecimalFormat("00.00");

	/** The price of ticket. */
	private BigDecimal price;

	/**
	 * Instantiates a new ticket.
	 *
	 * @param price
	 *            the price for ticket in USD
	 */
	public Ticket(BigDecimal price) {
		if (price.doubleValue() <= 0) {
			throw new IllegalArgumentException("Price must be positive and non-zero: " + price);
		} else {
			this.price = price;
		}
	}

	/**
	 * Compares the price of ticket to price of given ticket.
	 *
	 * @param t
	 *            the t
	 * @return 1 if this ticket more expensive, -1 if given ticket more
	 *         expensive, 0 if same price
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Ticket t) {
		return price.compareTo(t.getPrice());
	}

	/**
	 * Gets the formatted price in USD whilst displaying price to 2 decimal
	 * places with leading zeroes up to 2 digits.
	 *
	 * @return the formatted price as string
	 */
	public String getFormattedPrice() {
		return "$" + decimalFormatter.format(price.doubleValue());
	}

	/**
	 * Gets the price of ticket.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

}