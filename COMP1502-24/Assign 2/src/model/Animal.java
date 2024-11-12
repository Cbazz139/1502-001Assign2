package model;

/**
 * Animal class represents an animal toy
 * Inherits from the toy class
 * @author diltung
 */

public class Animal extends Toy{
	private String material;
	private String size;

	/**
	 * Animal toy constructor
	 * 
	 * @param serialNumber
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param material
	 * @param size
	 */
	public Animal(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String material, String size) {
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.material = material;
		this.size = size;
	}
	
	/**
	 * return the material of the toy
	 * 
	 * @return material of toy
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * sets the material of the toy
	 * 
	 * @param material of the toy
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * return size of the toy
	 * 
	 * @return size of the toy
	 */
	public String getSize() {
		return size;
	}

	/**
	 * sets the size of the toy
	 * 
	 * @param size of the toy
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Returns a string of the Animal toy
	 */
	@Override
	public String toString() {
		return super.toString() + " Material: " + material + " Size: " + size;
	}

}
