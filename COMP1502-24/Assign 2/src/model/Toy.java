package model;

/**
 * 
 * Toy superclass
 * @author diltung
 * 
 */
public abstract class Toy {

	private long serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availableCount;
	private int ageAppropriate;
	
	/**
	 * Toy constructor
	 * 
	 * @param serialNumber
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 */
	
	public Toy(long serialNumber, String name, String brand,double price, int availableCount, int ageAppropriate) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	}
	
	/**
	 * returns the serial number of the toy
	 * 
	 * @return serial number of the toy
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * sets the serial number of the toy
	 * 
	 * @param set the serial Number
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * returns the name of the toy
	 * 
	 * @return the name of the toy
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of the toy
	 * 
	 * @param name of the toy
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the brand of the toy
	 * 
	 * @return the brand of the toy
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * sets the brand of the toy
	 * 
	 * @param brand of the toy
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * return the price of the toy
	 * 
	 * @return the price of the toy
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets the price of the toy
	 * 
	 * @param price of the toy
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * return the available amount of the toy
	 * 
	 * @return the available amount of the toy
	 */
	public int getAvailableCount() {
		return availableCount;
	}

	/**
	 * sets the available amount of the toy
	 * 
	 * @param available amount of the toy
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	/**
	 * return the playable age of the toy
	 * 
	 * @return playable age of the toy
	 */
	public int getAgeAppropriate() {
		return ageAppropriate;
	}

	/**
	 * sets the playable age of the toy
	 * 
	 * @param playable age of the toy
	 */
	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}

	/**
	 * Returns a string of the toy, easy to read.
	 */
	@Override
	public String toString() {
		return "Serial Number: " + serialNumber + " Name: " + name + " Brand: " + brand + " Price: $" + price
				+ " Available Count: " + availableCount + " Appropriate Age: " + ageAppropriate;
	}
}
