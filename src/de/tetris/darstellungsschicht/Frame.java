package de.tetris.darstellungsschicht;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

public class Frame extends GUI{
	private static final int HOEHE = 800;
	private static final int BREITE = HOEHE;
	private CardLayout cardLayout = new CardLayout();
	
	public Frame() {
		super("Tetriges Tetris");
		setSize(BREITE, HOEHE);
		setBackground(Color.gray);
		
		setLayout(cardLayout);

	//	add(addLoginScreen());
//		add(addSpielfeld());
		add(addFrameLoginScreen());
		
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private Panel addFrameLoginScreen() {
		FrameLoginScreen frameLoginScreen = new FrameLoginScreen();
		return frameLoginScreen;
	}

	private Panel addSpielfeld() {
		FrameSpielfeld frameSpielfeld = new FrameSpielfeld();
		return frameSpielfeld;
	}

	private Panel addLoginScreen(){
		FrameHauptmenue frameLoginScreen = new FrameHauptmenue();
		return frameLoginScreen;
	}
}
