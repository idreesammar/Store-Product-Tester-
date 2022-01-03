
public abstract class StreamableProduct extends Product {
	// instance variables
	private double duration;
	private boolean isIncludedWithPrime;
	private int releaseYear;
	
	// constructor
	public StreamableProduct (String name, double price, double rating, double duration, boolean isIncludedWithPrime, int releaseYear) {
		super(name, price, rating);
		this.duration = duration;
		this.isIncludedWithPrime = isIncludedWithPrime;
		this.releaseYear = releaseYear;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the isIncludedWithPrime
	 */
	public boolean isIncludedWithPrime() {
		return isIncludedWithPrime;
	}

	/**
	 * @param isIncludedWithPrime the isIncludedWithPrime to set
	 */
	public void setIncludedWithPrime(boolean isIncludedWithPrime) {
		this.isIncludedWithPrime = isIncludedWithPrime;
	}

	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		if (this.isIncludedWithPrime) {
			return "(free with prime) " + super.toString();
		}
		else {
			return super.toString();
		}
	}
	
	

}
/*

 */
