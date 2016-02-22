package de.tetris.steuerungsschicht;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.darstellungsschicht.FrameHauptmenue;
import de.tetris.darstellungsschicht.FrameSpielfeld;
import de.tetris.datenschicht.PersistanceStore;
import de.tetris.datenschicht.PersistanceStoreMySQL;

public class Controller implements Runnable {
	private Thread thread;
	private boolean gameRunning;

	private Rotator rotator;
	private XMLSerializer xmlSerializer;
	private Frame frame;
	private PersistanceStoreMySQL persistancestore;
	private String user = "default";
	private ArrayList<String> userData;
	private Spielfeld spielfeld;


	public Controller() {
		Form form = new FormNormalMode();
		// Frame frame = new Frame();
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
	
	public void establishConnection(){
		// Setzen der AccountInformationen
		this.persistancestore.setInfo("localhost", "3306");
		
		// Name der Datenbank auf welche eine Verbindung aufgebaut werden soll.
		this.persistancestore.createConnection("Tetris");

		// DUMMY ABFRAGEN
		// create default user
		this.persistancestore.createUser("default", "default");
		this.userData = this.persistancestore.logIn("default", "default");
		
		System.out.println("LOGGED IS : " + userData.get(0) + " MESSAGE " + userData.get(1));
		
		//persistancestore.update("UPDATE tetrisuser SET Nickname=' +  + ' WHERE Nickname='pro'");
		
		//persistancestore.delete("DELETE FROM tetrisuser WHERE Nickname='ANDERS'");
			
		//persistancestore.insert("INSERT INTO tetrisuser (nickname, password, letzerSpielstand)" +
		//"VALUES ('Gollum','ABCDEFG112', '[0,1,2,3,4,5,6,7,10,[0,0,0]][0,1,2,3,4,5,6,7,10,[0,0,0]]')");
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
//		establishConnection();
		this.spielfeld = new Spielfeld();
		gameLoop();
	}
	
	public void createListener(JPanel panel) {
		ActionListener listener;
		if(panel instanceof FrameHauptmenue) {
			listener = new HauptmenueListener();
			((FrameHauptmenue) panel).getLoginButton().addActionListener(listener);
			((FrameHauptmenue) panel).getHighScoreButton().addActionListener(listener); 
		} else if (panel instanceof FrameSpielfeld) {
			listener = new SpielfeldListener();
			// Buttons ActionListener hinzufügen
		} else {
			// Fehlerausgabe
		}
		
		// noch nicht alle Screens berücksichtigt
	}
}
