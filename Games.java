
public class Games extends Item {
	// instance variables
	private String description;
	// constructor
	public Games(String name, double price, double rating, int quantity, String description) {
		super(name, price, rating, quantity);
		this.description = description;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Game: " + super.toString() + ", " + description;
	}
	
	

}
