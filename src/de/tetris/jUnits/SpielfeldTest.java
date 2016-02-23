package de.tetris.jUnits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.tetris.steuerungsschicht.Controller;
import de.tetris.steuerungsschicht.Spielfeld;

public class SpielfeldTest {
	
	@Test
	public void beruehrtRand() {

		Spielfeld spielfeld = new Spielfeld();
		boolean rand = spielfeld.isOutOfBounce(12, 5);
		boolean rand2 = spielfeld.isOutOfBounce(20, 5);
		boolean rand3 = spielfeld.isOutOfBounce(12, -5);

		assertFalse(rand);
		assertTrue(rand2);
		assertTrue(rand3);
	}

}
