package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BoardGame;

/**
 * Test for boardgame class
 * @author diltung
 */

class BoardGameTest {
	private BoardGame boardGame;
	
	/**
	 * Set up an instance of BoardGame class.
	 */
	@BeforeEach
	public void setUp() {
		boardGame = new BoardGame(1234567890, "Chess", "BoardGameBrand", 19.99, 10, 8, 2, "DesignerName", 2);
	}
	
	/**
	 * Test for the getmaxplayers method in the BoardGame class.
	 */
	@Test
	public void testGetMaxPlayers() {
		assertEquals(2, boardGame.getMaxPlayers());
	}
	
	/**
	 * Test for the setDesigner method in the BoardGame class.
	 */
	@Test
	public void testGetDesigners() {
		assertEquals("DesignerName", boardGame.getDesigners());
	}

	
	}


