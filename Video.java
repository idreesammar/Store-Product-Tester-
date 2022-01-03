
public class Video extends StreamableProduct implements Rentable {
	// instance variables
	private Genre genre; 
	// constructor
	public Video(String name, double price, double rating, double duration, boolean isIncludedWithPrime,
			int releaseYear, Genre genre) {
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		this.genre = genre;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	
	@Override
	public String toString() {
		return "Streamable Video " + super.toString() + ", Genre = " + this.genre;
	}

	@Override
	public double getRentalPrice() {
		if (this.isIncludedWithPrime() == true) {
			return 0.0;
		}
		else { // no prime
			return this.getPrice() / 3.0;
		}
	}

}
