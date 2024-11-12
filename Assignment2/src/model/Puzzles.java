package model;

/**
 * Represents a Puzzle toy
 * Inherits from the Toy class.
 * @author diltung
 */
public class Puzzle extends Toy{
	
	private String puzzleType;

	/**
	 * Constructs a Puzzle toy
	 * 
	 * @param serialNumber
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param puzzleType
	 */
	public Puzzle(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate,
			String puzzleType) {
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.puzzleType = puzzleType;
	}

	/**
	 * returns the type of puzzle
	 * 
	 * @return type of puzzle
	 */
	public String getPuzzleType() {
		return puzzleType;
	}

	/**
	 * sets the type of puzzle
	 * 
	 * @param type of puzzle
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}

	/**
	 * Returns a string of the Puzzle toy
	 */
	@Override
	public String toString() {
		return super.toString() + " Puzzle Type: " + puzzleType;

	}

}
