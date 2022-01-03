

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * NOTE: you do not have to currently understand what this file does.
 * @author kendra
 *
 */

public class StoreFactory {
	private static final String PRODUCT_FILE = "src/products.csv";
	private static final String STREAMABLE_FILE = "src/streamable.csv";

		public static void main(String[] args) {
		Product[] prods = setUpStoreProducts();
		for(Product p: prods) {
			System.out.println(p);
		}
	}
	public static Product[] setUpStoreProducts() {
		List<Product> allProducts = new ArrayList<>();
		readFile(PRODUCT_FILE, allProducts);
		readFile(STREAMABLE_FILE, allProducts);
		
		Product[] array = new Product[allProducts.size()];
		for(int i = 0; i < allProducts.size(); i++) {
			array[i] = allProducts.get(i);
			
		}
		
		return array;
	}

	/**
	 * @param productFile
	 * @return
	 */
	private static void readFile(String file, List<Product> list) {
		try(FileInputStream fis = new FileInputStream(file);
				Scanner scan = new Scanner(fis))
		{  // NOTE: resources will be closed automatically with this try block
			if (scan.hasNext()) {
				String header = scan.nextLine();
				while(scan.hasNextLine()) {
					String line = scan.nextLine();
					Product p = parseStringIntoProduct(line);
					if(p != null) {
						list.add(p);
					}
				}
			}
			else {
				System.err.println("File was empty: " + file);
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("File not found: " + file);
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 


	}

	/**
	 * @param line
	 * @return
	 */
	private static Product parseStringIntoProduct(String line) {
		//CSV format:
		//Product Type,Name,Price,Rating,Item or Streamable,Item quantity,Streamable duration,withPrime,releaseYear,Other Data
		Product product = null;
		try {
		
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String type = sc.next();
			String rest = sc.nextLine();
			if(type.equalsIgnoreCase("Item")) {
				product = parseItem(rest);
			}
			else if(type.equalsIgnoreCase("Streamable")) {
				product = parseStreamable(rest);

			}else {
				System.err.println("Unknown category in file: " + type);
			}

		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
		}
		return product;
	}


	private static StreamableProduct parseStreamable(String line) {
		StreamableProduct thing = null;
		try {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String productType = sc.next();
			String name = sc.next();
			double price = sc.nextDouble();
			double rating = sc.nextDouble();
			double duration = sc.nextDouble();
			boolean withPrime = sc.nextBoolean();
			int releaseYear = sc.nextInt(); 
			String otherData = sc.nextLine().substring(1);
			if(productType.equalsIgnoreCase("Music")) {
				MusicGenre genre = parseMusicGenre(otherData);
				thing = new Music(name, price, rating, duration, withPrime, releaseYear, genre);
			}
			else if(productType.equalsIgnoreCase("Video")) {
				Genre genre = parseVideoGenre(otherData);
				thing = new Video(name, price, rating, duration, withPrime, releaseYear, genre);
			}

		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
		}
		return thing;
	}

	/**
	 * @param otherData
	 * @return
	 */
	private static Genre parseVideoGenre(String otherData) {
		Genre genre = Genre.valueOf(otherData.toUpperCase());
	
		return genre;
	}

	/**
	 * @param otherData
	 * @return
	 */
	private static MusicGenre parseMusicGenre(String otherData) {
		return MusicGenre.valueOf(otherData.toUpperCase()) ;
	
	}
	/**
	 * @param nextLine
	 * @return
	 */
	private static Item parseItem(String line) {
		Item item = null;
		try {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			String productType = sc.next();
			String name = sc.next();
			double price = sc.nextDouble();
			double rating = sc.nextDouble();
			int quantity = sc.nextInt();
			// get otherData column(s)
			if(productType.equalsIgnoreCase("Book")) {
				String genre =  sc.next();
				int numPages =  sc.nextInt();
				item = new Book(name, price, rating, quantity, genre, numPages);
			}
			else if(productType.equalsIgnoreCase("Electronic")) {
				String dim =  sc.next();
				String weight= sc.next();
				item = new Electronics(name, price, rating, quantity,dim, weight);
			}		
			else if(productType.equalsIgnoreCase("Games")) {
				String otherData = sc.next();
				item = new Games(name, price, rating, quantity,otherData);
			}	
		}
		catch(Exception e) {
			System.err.println("Error reading line of file: " + line + "\nerror; " + e);
			e.printStackTrace();
		}
		return item;
	}


}
