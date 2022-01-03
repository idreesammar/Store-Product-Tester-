
public class Book extends Item implements Rentable {
	// instance variables
	private String genre;
	private int numberOfPages;
	private final double RENTAL_PRICE = 0.99;
	// constructor
	public Book(String name, double price, double rating, int quantity, String genre, int numberOfPages) {
		super(name, price, rating, quantity);
		this.genre = genre;
		this.numberOfPages = numberOfPages;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	@Override
	public double getRentalPrice() {
		return this.RENTAL_PRICE;
	}

	@Override
	public String toString() {
		return super.toString() + " genre = " + this.genre + " and numPages = " + this.numberOfPages;
	}

}
