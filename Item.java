
public abstract class Item extends Product {
	// instance variables
	private int quantity;
	
	// constructor
	public Item(String name, double price, double rating, int quantity) {
		super(name,price,rating);
		this.quantity = quantity;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	

}




// NOTES
//