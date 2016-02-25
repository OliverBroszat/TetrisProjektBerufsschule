package de.tetris.steuerungsschicht;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JPanel;

import de.tetris.darstellungsschicht.Frame;
import de.tetris.darstellungsschicht.FrameBasicFrame;
import de.tetris.darstellungsschicht.FrameCreateUser;
import de.tetris.darstellungsschicht.FrameHauptmenue;
import de.tetris.darstellungsschicht.FrameHighscore;
import de.tetris.darstellungsschicht.FrameLoginScreen;
import de.tetris.darstellungsschicht.FramePauseMenue;
import de.tetris.darstellungsschicht.FrameSpielfeld;
import de.tetris.datenschicht.PersistanceStoreMySQL;
import de.tetris.steuerungsschicht.Listener.BasicFrameListener;
import de.tetris.steuerungsschicht.Listener.CreateUserListener;
import de.tetris.steuerungsschicht.Listener.HauptmenueListener;
import de.tetris.steuerungsschicht.Listener.HighscoreListener;
import de.tetris.steuerungsschicht.Listener.LoginScreenListener;
import de.tetris.steuerungsschicht.Listener.PausemenueListener;
import de.tetris.steuerungsschicht.Listener.SpielfeldListener;

public class Controller implements Runnable {
	private Thread thread;
	private boolean gameRunning;
	private boolean pause = false;
	private Rotator rotator;
	private Frame frame;
	private PersistanceStoreMySQL persistancestore;
	private String user = "default";
	private ArrayList<String> userData;
	private Spielfeld spielfeld;
	private RenderClass renderClass;

	public Controller() {
		frame = new Frame(this);
		this.spielfeld = new Spielfeld();
		frame.addFrames();
		Form form = new FormNormalMode();
		// formList.add(form);
		persistancestore = new PersistanceStoreMySQL();
	}

	/**
	 * Startet das Spiel und die dazugehörigen Threads Soll es ermöglichen,
	 * mehrere Spiele starten zu können
	 */
	public void startGame() {
		thread = new Thread(this);
		thread.start();
		pause = false;
	}

	public void establishConnection() {
		// Setzen der AccountInformationen
		this.persistancestore.setInfo("localhost", "3306");

		// Name der Datenbank auf welche eine Verbindung aufgebaut werden soll.
		this.persistancestore.createConnection("Tetris");

		// DUMMY ABFRAGEN
		// create default user
		this.persistancestore.createUser("default", "default");
		this.userData = this.persistancestore.logIn("default", "default");

		System.out.println("LOGGED IS : " + userData.get(0) + " MESSAGE " + userData.get(1));

		// persistancestore.update("UPDATE tetrisuser SET Nickname=' + + ' WHERE
		// Nickname='pro'");

		// persistancestore.delete("DELETE FROM tetrisuser WHERE
		// Nickname='ANDERS'");

		// persistancestore.insert("INSERT INTO tetrisuser (nickname, password,
		// letzerSpielstand)" +
		// "VALUES ('Gollum','ABCDEFG112',
		// '[0,1,2,3,4,5,6,7,10,[0,0,0]][0,1,2,3,4,5,6,7,10,[0,0,0]]')");
	}

	// TODO Oliver
	public void stopGame() {
		gameRunning = false;
		renderClass = null;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread = null;
	}

	/**
	 * Wird solange das Spiel läuft 60 mal pro Sekunde aufgerufen werden und das
	 * Spielfeld rendern und die gamelogik aufrufen
	 */
	public void gameLoop() {
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		int anzahlDurchläufe = 0;

		// keep looping round until the game ends
		while (gameRunning) {
			while (!pause) {
				long now = System.nanoTime() - lastLoopTime;

				if (now >= OPTIMAL_TIME) {
					lastLoopTime = System.nanoTime();

					// TODO Oliver
					renderClass.render();
					anzahlDurchläufe++;

					if (anzahlDurchläufe >= 60) {
						gamelogic();
						anzahlDurchläufe = 0;
					}
				}
			}
		}
	}

	private void gamelogic() {
		spielfeld.move("down");
	}

	@Override
	public void run() {
		// TODO Michael was macht das hier?
		// establishConnection();
		gameRunning = true;
		spielfeld.startSpiel();
		renderClass = new RenderClass(frame.getPanelSpielfeld(), spielfeld);
		gameLoop();
	}

	public void spielfedRequestFocus(JPanel panel) {
		panel.requestFocusInWindow();
	}

	public void createListener(JPanel panel) {
		ActionListener aListener;
		if (panel instanceof FrameLoginScreen) {
			aListener = new LoginScreenListener(frame);
			((FrameLoginScreen) panel).getSubmitButton().addActionListener(aListener);
			((FrameLoginScreen) panel).getNewUserButton().addActionListener(aListener);

		} else if (panel instanceof FrameHauptmenue) {
			System.out.println("cont: " + frame);
			aListener = new HauptmenueListener(frame);
			((FrameHauptmenue) panel).getLoginButton().addActionListener(aListener);
			((FrameHauptmenue) panel).getHighScoreButton().addActionListener(aListener);
			((FrameHauptmenue) panel).getStartenButton().addActionListener(aListener);

		} else if (panel instanceof FrameSpielfeld) {
			KeyListener kListener = new SpielfeldListener(frame, spielfeld);
			panel.addKeyListener(kListener);
			
		} else if (panel instanceof FrameCreateUser) {
			aListener = new CreateUserListener(frame);
			((FrameCreateUser) panel).getNewUserButton().addActionListener(aListener);
		
		} else if (panel instanceof FramePauseMenue) {
			aListener = new PausemenueListener(frame);
			((FramePauseMenue) panel).getHauptmenueButton().addActionListener(aListener);
			((FramePauseMenue) panel).getSpeichernButton().addActionListener(aListener);
			((FramePauseMenue) panel).getSpeichernButton().addActionListener(aListener);
		
		} else if (panel instanceof FrameHighscore) {
			aListener = new HighscoreListener(frame);
			((FrameHighscore) panel).getZurueck().addActionListener(aListener);
		} 
		
		if (panel instanceof FrameBasicFrame) {
			aListener = new BasicFrameListener(frame);
			((FrameBasicFrame) panel).getPauseButton().addActionListener(aListener);
		}
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean getPause() {
		return pause;
	}
		
	public Thread getThread() {
		return thread;
	}
	
	public Spielfeld getSpielfeld(){
		return spielfeld;
	}
}
