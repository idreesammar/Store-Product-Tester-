import java.util.Objects;

public abstract class Product implements Comparable<Product> {

	// instance variables
	private String name;
	private double price;
	private double rating;
	
	// constructor
	public Product(String name, double price, double rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	@Override 
	public int compareTo (Product other) {
		if (this.equals(other)) return 0; // they are the same object
		int num = Double.compare(this.price, other.price);  // essentially does the same thing as Math.abs(value1-value2) < error
		if (num == 0) { // prices were the same
			num = this.name.compareTo(other.name); // check name
		}
		if (num == 0) { // names were also the same
			num = Double.compare(this.rating, other.rating);
		}
		return num;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		return this.name.equalsIgnoreCase(other.name) 
				&& (Math.abs(this.rating-other.rating) <= 0.0001)
				&& (Math.abs(this.price-other.price) <= 0.0001);
	}
	
	@Override
	public String toString() {
		return this.name + ", price = $" + String.format("%.2f", price) + ", rating=" + rating + "⭐";
		
	}
	
	
	
	

}

/*
 * 1) is my equals method fine
 * 2) did i do compareTo correctly --> can we use Double.compare?
 */

