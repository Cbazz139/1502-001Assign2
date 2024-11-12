package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Animal;

/**
 * Test for Animal class
 * @author diltung
 */
class AnimalTest {
	private Animal animal;
	
	@BeforeEach
	public void setUp() {
		animal = new Animal(1234567890, "Elephant", "AnimalBrand", 19.99, 10, 3, "dilpreet", "Large");
	}
 
	/**
	 * Test for the setMaterial method in the Animal class.
	 */
	@Test
	public void testSetMaterial() {
		animal.setMaterial("Rubber");
		assertEquals("Rubber", animal.getMaterial());
	}
	
	/**
	 * Test for the setSize method in the Animal class.
	 */
	@Test
	public void testSetSize() {
		animal.setSize("Small");
		assertEquals("Small", animal.getSize());
	}
	

}
