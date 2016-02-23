package de.tetris.jUnits;

import static org.junit.Assert.*;

import org.junit.Test;

import de.tetris.steuerungsschicht.Controller;

public class ControllerTests {
	 @Test
	  public void threadAlive() {
		 
		 Controller control = new Controller();
		 control.startGame();
		  
		  assertTrue(control.getThread().isAlive());

	  }
	  
	 @Test
	  public void threadDead() {
		 
		 Controller control = new Controller();
		 control.stopGame();
		  
		  assertFalse(control.getThread().isAlive());

	  }

}
