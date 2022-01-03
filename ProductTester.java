
import java.util.*;

/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265, Section
 * Email: kwalther@usc.edu
 *
 */
public class ProductTester {

	private Product[] allProducts;

	public ProductTester() {
		allProducts = StoreFactory.setUpStoreProducts();
	}

	public static void main(String[] args) {
		System.out.println("PRODUCT TESTER");
		ProductTester store = new ProductTester();
		
		System.out.println("\nMETHOD 0 --All items (full to String)");
		store.showAll();
		
		System.out.println("METHOD 1 -- All products in the store:");
		store.printProductPriceAndName();
		
		System.out.println("\nMETHOD 2 -- All products in the store, sorted by price");
		store.showItemsByPrice();

		System.out.println("\nMETHOD 3 --Inventory in the store by Product Type");
		store.showInventoryByCategory();
		System.out.println("\nMETHOD 4 --Rentable items:");
		store.showRentals();

		

	}
	// METHOD 0
	private void showAll() { 
		Arrays.sort(allProducts); // sort the string using compareTo
		for (Product p: allProducts) {
			System.out.println(p);  // call's each object's toString method
		}
		System.out.println(); // newline
	}

	// METHOD 1
	public void printProductPriceAndName() {
		for (int i = allProducts.length-1; i >= 0; i--) { // loops through all products and outputs respective price/name
			System.out.println(String.format("$%.2f", allProducts[i].getPrice()) + " : " + allProducts[i].getName());
		}
		//TODO -- can use friendly to help get the price of a given product p in a user-friendly format
		//String friendly = String.format("$%.2f", p.getPrice());
	}

	// METHOD 2
	private void showItemsByPrice() {
		Arrays.sort(allProducts); // sort the string using compareTo
		for (int i = 0; i < allProducts.length; i++) { // loop through sorted array of products
			System.out.println(String.format("$%.2f", allProducts[i].getPrice()) + " : " + allProducts[i].getName());
		}
	}
	
	// METHOD 3
	public void showInventoryByCategory() {
		for (ProductType type: ProductType.values()) { // looping through ProductType enum
			System.out.println(type); // for category title
			ArrayList typeList = getCategoryList(type); // makes a list of all objects of that category
			if (typeList.isEmpty()) {
				System.out.println("\tNo matching items");  // if the list has no products
			}
			else { // the list has at least one product
				for (Object o: typeList) {
					System.out.println("\t" + o);
				}
			}
		}
	}
	
	// helper method for METHOD 3
	private ArrayList<Product> getCategoryList(ProductType type) {
		ArrayList<Product> items = new ArrayList<>();
		for(Product p: allProducts) {
			if(p.getClass().getSimpleName().equalsIgnoreCase(type.toString())){
				items.add(p);
			}
		}
		return items;
	}


	// METHOD 4
	private void showRentals() {
		for (Product p: allProducts) {  // loop through all products 
			if (p instanceof Rentable) { // find those that use Rentable interface
				Rentable r = (Rentable)p; // cast the product as rentable to call upon getRentalPrice method
				System.out.println("(Rent from : " + String.format("$%.2f", r.getRentalPrice()) + ") - " + p.getName());
			}
		}
		// loop through all the products and see if a given product is Rentable
		// print each rentable product in the form, with rental price and name of product
		//(Rent from : $0.00) - Psych

		//TODO
	}
	
	
}
