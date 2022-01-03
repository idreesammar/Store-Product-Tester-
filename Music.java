
public class Music extends StreamableProduct {
	// instance variables
	private MusicGenre musicGenre;
	
	// constructor
	public Music(String name, double price, double rating, double duration, boolean isIncludedWithPrime,
			int releaseYear, MusicGenre musicGenre) {
		super(name, price, rating, duration, isIncludedWithPrime, releaseYear);
		this.musicGenre = musicGenre;
	}
	
	@Override
	public String toString() {
		return "Streamable Music " + super.toString() + ", Genre: " + this.musicGenre;
	}
	
}
