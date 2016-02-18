package de.tetris.steuerungsschicht;

public class Controller {
	private Thread thread;
	private boolean gameRunning;
	
	public Controller() {
		thread = new Thread();
		gameRunning = true;
	}
	
	
	public void gameLoop()
	{
	   long lastLoopTime = System.nanoTime();
	   final int TARGET_FPS = 60;
	   final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   

	   // keep looping round until the game ends
	   while (gameRunning)
	   {
	      long now = System.nanoTime() - lastLoopTime;
	      
	      if(now >= OPTIMAL_TIME){
	    	  lastLoopTime = System.nanoTime();
	    	
	    	  //TODO mach dat
	    	  	//render();
	    	  
	    	  	//gamelogic();
	      }
	   }
	}
}
