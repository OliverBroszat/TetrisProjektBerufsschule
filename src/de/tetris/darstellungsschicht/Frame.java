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

public class Frame extends GUI{
	private static final int HOEHE = 800;
	private static final int BREITE = HOEHE;
	private CardLayout cardLayout = new CardLayout();
	private Controller controller;
	private JPanel panel;
	
	public Frame(Controller controller) {
		super("Tetriges Tetris");
		setSize(BREITE, HOEHE);
		setBackground(Color.gray);
		
		setLayout(cardLayout);

		this.controller = controller;
		
	//	add(addLoginScreen());
		add(addSpielfeld());
	//	add(addFrameLoginScreen());
		
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		controller.spielfedRequestFocus(panel);
	}
	
	private Panel addCreateUserScreen() {
		FrameCreateUser frameCreateUser = new FrameCreateUser();
		controller.createListener(frameCreateUser);
		return frameCreateUser;
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

	private Panel addLoginScreen() {
		FrameHauptmenue frameLoginScreen = new FrameHauptmenue();
		controller.createListener(frameLoginScreen);
		return frameLoginScreen;
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
