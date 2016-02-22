package de.tetris.steuerungsschicht;

import java.util.ArrayList;
import java.util.List;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.datenschicht.PersistanceStoreMySQL;

public class Controller implements Runnable {
	private Thread thread;
	private boolean gameRunning;

	private Rotator rotator;
	private XMLSerializer xmlSerializer;
	private List<Form> formList = new ArrayList<Form>();
	private Frame frame;
	private PersistanceStoreMySQL persistancestore;

	public Controller() {
		persistancestore = new PersistanceStoreMySQL();
		
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
	
	public void etablishConnection(){
		// Setzen der AccountInformationen
		this.persistancestore.setInfo("localhost", "3306");
		
		// Name der Datenbank auf welche eine Verbindung aufgebaut werden soll.
		this.persistancestore.createConnection("Tetris");
		
		String stmt3 = "SELECT (p.punkte * s.faktor) AS 'Highscores' " +
				", u.nickname, s.schwierigkeit " +
				"FROM tetrisuser u " +
				"JOIN punktestaende p " +
				"ON u.userID = p.userID " +
				"JOIN schwierigkeitsgrad s " +
				"ON p.schwierigkeit = s.schwierigkeit " +
				"ORDER BY (p.punkte * s.faktor) DESC";
		
		ArrayList<ArrayList<String>> data1 = persistancestore.select("SELECT * FROM tetrisuser");
		
		persistancestore.update("UPDATE tetrisuser SET Nickname=' +  + ' WHERE Nickname='pro'");
		
		//persistancestore.delete("DELETE FROM tetrisuser WHERE Nickname='ANDERS'");
			
		persistancestore.insert("INSERT INTO tetrisuser (nickname, password, letzerSpielstand)" +
		"VALUES ('Gollum','ABCDEFG112', '[0,1,2,3,4,5,6,7,10,[0,0,0]][0,1,2,3,4,5,6,7,10,[0,0,0]]')");
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
					//System.out.println("loop");
				// gamelogic();
			}
		}
	}

	@Override
	public void run() {
		etablishConnection();
		gameLoop();
	}
}
