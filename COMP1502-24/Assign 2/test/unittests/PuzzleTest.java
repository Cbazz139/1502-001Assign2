package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Puzzle;

/**
 * Test of puzzle class
 * @author diltung
 */

class PuzzleTest {
	private Puzzle puzzle;
	
	/**
	 * Set up an instance of Puzzle class.
	 */
	@BeforeEach
	public void setUp() {
		puzzle = new Puzzle(1234567890, "Crossword", "PuzzleBrand", 9.99, 5, 12, "Sudoku");
	}

	/**
	 * test of setPuzzleType method in puzzle class
	 */
	@Test
	public void testSetPuzzleType() {
		puzzle.setPuzzleType("Crossword");
		assertEquals("Crossword", puzzle.getPuzzleType());
	}

	/**
	 * test of getAvailableCount method in puzzle class
	 */
	@Test
	public void testGetAvailableCount() {
		assertEquals(5, puzzle.getAvailableCount());
	}

	

}
