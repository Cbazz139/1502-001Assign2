package model;

/**
 * Represents a figure toy
 * Inherits from the toy class
 * @author diltung
 */
public class Figure extends Toy{
	private String classification;

	/**
	 * Constructs a Figure toy
	 * 
	 * @param serialNumber
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param classification
	 */
	public Figure(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate,
			String classification) {
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.classification = classification;
	}

	/**
	 * return the classification of the figure
	 * 
	 * @return classification of the figure
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * sets the classification of the figure
	 * 
	 * @param classification of the figure
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * Returns a string of the Figure toy
	 */
	@Override
	public String toString() {
		return super.toString() + " Classification: " + classification;
	}

}
