package model;

/**
 * Represents the board game toy
 * Inherits from the toy class
 * @author diltung
 */
public class BoardGame extends Toy{
	private int maxPlayer;
	private int minPlayer;
	private String designers;

	/**
	 * Constructs a Board Game toy
	 * 
	 * @param serialNumber
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param maxPlayer
	 * @param designers
	 * @param minPlayer
	 */
	public BoardGame(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate,
			int maxPlayer, String designers, int minPlayer) {
		super(serialNumber, name, brand, price, availableCount, ageAppropriate);
		this.maxPlayer = maxPlayer;
		this.minPlayer = minPlayer;
		this.designers = designers;

	}

	/**
	 * return the maximum number players that can play the game
	 * 
	 * @return maximum number of players
	 */
	public int getMaxPlayers() {
		return maxPlayer;
	}

	/**
	 * set maximum number of players that can play the game
	 * 
	 * @param maximum number of players
	 */
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	/**
	 * return the designer of the toy
	 * 
	 * @return designer of the toy
	 */
	public String getDesigners() {
		return designers;
	}

	/**
	 * sets the designer of the toy
	 * 
	 * @param designers of the toy
	 */
	public void setDesigners(String designers) {
		this.designers = designers;
	}

	/**
	 * return minimum number of player that can play the game
	 * 
	 * @return minimum number of player
	 */
	public int getMinPlayer() {
		return minPlayer;
	}

	/**
	 * sets minimum number of player that can play the game
	 * 
	 * @param minimum number of player
	 */
	public void setMinPlayer(int minPlayer) {
		this.minPlayer = minPlayer;
	}

	/**
	 * Returns a string of the Board Game toy
	 */
	@Override
	public String toString() {
		return super.toString() + " Number of Players: " + minPlayer + "-" + maxPlayer + " Designer: " + designers;
	}

}
