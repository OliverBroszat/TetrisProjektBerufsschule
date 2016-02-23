package de.tetris.darstellungsschicht;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import de.tetris.steuerungsschicht.Controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import de.tetris.steuerungsschicht.Controller;

public class Frame extends GUI {
	private static final int HOEHE = 800;
	private static final int BREITE = HOEHE;
	private CardLayout cardLayout = new CardLayout();
	private Controller controller;
	private JPanel backgroundFrame = new JPanel();
	private JPanel panel;

	public Frame(Controller controller) {
		super("Tetriges Tetris");
		setSize(BREITE, HOEHE);
		setBackground(Color.gray);

		backgroundFrame.setLayout(cardLayout);

		this.controller = controller;

		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		add(backgroundFrame);
	}

	public void addFrames() {
		backgroundFrame.add(addHauptmenue(), "HauptMenue");
		backgroundFrame.add(addSpielfeld(), "Spielfeld");
		backgroundFrame.add(addFrameLoginScreen(), "Login");
		backgroundFrame.add(addFramePauseMenue(), "PauseMenue");
		backgroundFrame.add(addFrameHighscore(), "Highscore");
		
		controller.spielfedRequestFocus(panel);
	}

	//TODO ActionListener Marvin/Oliver
	private Panel addFrameHighscore() {
		FrameHighscore frameHighscore = new FrameHighscore();
		return frameHighscore;
	}

	//TODO ActionListener Marvin/Oliver
	private Panel addFramePauseMenue() {
		FramePauseMenue panelPauseMenue = new FramePauseMenue();
		return panelPauseMenue;
	}

	private Panel addFrameLoginScreen() {
		FrameLoginScreen frameLoginScreen = new FrameLoginScreen();
		controller.createListener(frameLoginScreen);
		return frameLoginScreen;
	}

	private Panel addSpielfeld() {
		FrameSpielfeld frameSpielfeld = new FrameSpielfeld();
		panel = frameSpielfeld;
		controller.createListener(frameSpielfeld);
		return frameSpielfeld;
	}

	private Panel addHauptmenue() {
		FrameHauptmenue frameHauptmenue = new FrameHauptmenue();
		controller.createListener(frameHauptmenue);
		return frameHauptmenue;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JPanel getBackgroundFrame() {
		return backgroundFrame;
	}

	public void setBackgroundFrame(JPanel backgroundFrame) {
		this.backgroundFrame = backgroundFrame;
	}
}
