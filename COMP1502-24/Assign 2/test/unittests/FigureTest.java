package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Figure;

/**
 * Test for figure class
 * @author diltung
 */
class FigureTest {
	private Figure figure;
	
	/**
	 * Sets up with an instance of the Figure class.
	 */
	@BeforeEach
	public void setUp() {
		figure = new Figure(1234567890, "Superman", "FigureBrand", 29.99, 5, 6, "Superhero");
	}

	/**
	 * test of setClassification method in Figure class
	 */
	@Test
	public void testSetClassification() {
		figure.setClassification("dilpreet");
		assertEquals("dilpreet", figure.getClassification());
	}


}
