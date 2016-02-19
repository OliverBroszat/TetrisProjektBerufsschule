package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.datenschicht.PersistanceStore;

public class Controller implements Runnable {
	private Thread thread;
	private boolean gameRunning;

	private Rotator rotator;
	private XMLSerializer xmlSerializer;
	private List<Form> formList = new ArrayList<Form>();
	private Frame frame;
	private PersistanceStore persistancestore;

	public Controller() {
		Form form = new FormNormalMode();
		startGame();
	}
	
	/**
	 * Startet das Spiel und die dazugehörigen Threads
	 * Soll es ermöglichen, mehrere Spiele starten zu können
	 */
	public void startGame() {
		thread = new Thread(this);
		gameRunning = true;
		thread.start();
	}
	
	//TODO Oliver
	public void stopGame(){
		gameRunning = false;
	}

	/**
	 * Wird solange das Spiel läuft 60 mal pro Sekunde aufgerufen werden
	 * und das Spielfeld rendern
	 * und die gamelogik aufrufen
	 */
	public void gameLoop() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

		// keep looping round until the game ends
		while (gameRunning) {
			long now = System.nanoTime() - lastLoopTime;

			if (now >= OPTIMAL_TIME) {
				lastLoopTime = System.nanoTime();

				// TODO Oliver
				// render();
					System.out.println("loop");
				// gamelogic();
			}
		}
	}

	@Override
	public void run() {
		gameLoop();
	}
}
