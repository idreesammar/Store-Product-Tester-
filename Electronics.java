
public class Electronics extends Item {
	// instance variables
	private String size; 
	private String weight;
	// constructor
	public Electronics(String name, double price, double rating, int quantity, String size, String weight) {
		super(name, price, rating, quantity);
		this.size = size;
		this.weight = weight;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", size = " + size + ", weight = " + weight;
	}
	

}
