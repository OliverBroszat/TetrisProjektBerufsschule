package de.tetris.darstellungsschicht;

import java.awt.CardLayout;
import java.awt.Color;

public class Frame extends GUI{
	private static final int H�HE = 800;
	private static final int BREITE = H�HE;
	private CardLayout cardLayout = new CardLayout();
	
	public Frame() {
		super("Tetriges Tetris");
		setSize(BREITE, H�HE);
		setBackground(Color.gray);
		
		setLayout(cardLayout);
		
		add(addSpielfeld());
		add(addLoginScreen());
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private Panel addSpielfeld() {
		FrameSpielfeld frameSpielfeld = new FrameSpielfeld();
		return frameSpielfeld;
	}

	private Panel addLoginScreen(){
		Panel tPanel = new Panel();
		tPanel.setSize(BREITE,H�HE);

		return tPanel;
	}

}
